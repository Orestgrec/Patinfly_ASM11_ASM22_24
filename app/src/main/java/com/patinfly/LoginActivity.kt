package com.patinfly

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.dbDataSource.UserDao
import com.patinfly.data.dataSource.user.UserDataSource

import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.usecase.LoginUsecase
import com.patinfly.ui.theme.ui.theme.PatinflyTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.InputStream
import java.nio.charset.StandardCharsets

class LoginActivity :ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   //UserLoginForm(LoginUsecase((UserRepository(UserDao.getInstance(LocalContext.current,)))))
//                    UserLoginForm(LoginUsecase((UserRepository(
//                        UserDataSource.getInstance(LocalContext.current,AppDatabase.getDatabase(
//                        LocalContext.current).userDataSource())))))
//                   ))

                    UserLoginForm(LoginUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )

                }
            }
        }
    }

    // load data from json file in assets and return json Array
private fun loadJson():JSONArray?{
   return try {
    val inputStream:InputStream= assets.open("user.json")
        val size:Int=inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()


        val json = String(buffer, StandardCharsets.UTF_8)
        val jsonArray = JSONArray(json)

       jsonArray
    }catch (error:Exception){
        Log.e("TAG","loadJson: error")
        null
    }
 }

}

@Composable
fun UserLoginForm(loginUsecase: LoginUsecase){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    Surface {
        Column (modifier = Modifier.width(300.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            var email by remember {
                mutableStateOf(TextFieldValue("")) }
            var password by remember {
                mutableStateOf(TextFieldValue("")) }

            var error by rememberSaveable { mutableStateOf(String())}

            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                TextField(value = email, label = { Text(text="email") } , onValueChange ={email= it}, )
            }
            Row (modifier = Modifier.padding(vertical = 8.dp)){
                TextField(value = password, label = { Text(text="Password") } , onValueChange ={password= it}, )


            }
            Row{
                Button(modifier = Modifier.width(200.dp),content ={Text(text="Login")} ,onClick = {
//                        try {
//                        Log.e("TAG check","the check result ${loginUsecase.execute(email)}")
//                        val check =loginUsecase.execute(email)
//                        if (check=="user approved"){
//                            // send email to Profile Activity so we can fetch its Info
//                            val intent = Intent(context, ProfileActivity::class.java)
//                            intent.putExtra("email",email.text)
//                            context.startActivity(intent)
//                        }else{
//                            // in case of Wrong email we show an error text
//                            error="Wrong Credentials"
//                        }
//                        }catch (error:Exception){
//                            Log.e("TAG check error","Wrong Credentials")
//                        }
                    coroutineScope.launch {withContext(Dispatchers.IO) {
                        try {
                            val userIsValidated = loginUsecase.execute(email)

                            if (userIsValidated) {
                                // send email to Profile Activity so we can fetch its Info
                                val intent = Intent(context, ProfileActivity::class.java)
                                val sendEmail:String =email.text
                                intent.putExtra("email",sendEmail)
                                context.startActivity(intent)

                            }else{
                                error="Wrong Credentials"
                                // in case of Wrong email we show an error text
                            }
                        }catch (error:Exception){
                            Log.e("TAG check error","TAG check error")
                        }

                    }          }
                })}
            Row{
                Button(modifier = Modifier.width(200.dp),content ={Text(text="Register")} ,onClick = {
                    // navigate to Login Activity
                    context.startActivity(Intent(context, RegisterActivity::class.java))
                })
            }

            // implement error text just in case of Wrong email
            if (true){
            Row{
                Text(text = error, modifier = Modifier.width(150.dp))
                }
            }
            }

        }

}



@Preview(showBackground = true)
@Composable
fun UserLoginFormPreview(){
    UserLoginForm(LoginUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )

}