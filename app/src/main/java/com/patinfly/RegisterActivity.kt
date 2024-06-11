package com.patinfly

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.user.UserDataSource
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.usecase.RegisterUsecase
import com.patinfly.ui.theme.PatinflyTheme
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

class RegisterActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserRegisterForm(RegisterUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )


                }
            }
        }
    }

}
@Composable
 fun UserRegisterForm(registerUsecase: RegisterUsecase){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Surface {
        Column (modifier = Modifier.width(300.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            var email by remember {
                mutableStateOf(TextFieldValue("")) }
            var userName by remember {
                mutableStateOf(TextFieldValue("")) }
            var password by remember {
                mutableStateOf(TextFieldValue("")) }
            Row (modifier = Modifier.padding(vertical = 8.dp)){
                TextField(value = userName, label = { Text(text="user name") } , onValueChange ={ userName= it} )
            }
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                TextField(value = email, label = { Text(text="email") } , onValueChange ={email= it} )
            }
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                TextField(value = password, label = { Text(text="password") } , onValueChange ={password= it} )
            }
            Row{
                Button(modifier = Modifier.width(200.dp),content ={Text(text="Sign Up")} ,onClick = {
                    if (email.text.isNotEmpty() && userName.text.isNotEmpty() && password.text.isNotEmpty()){
                    try {
                        // sending coming data from user to be stored in repository
                        coroutineScope.launch {
                            registerUsecase.execute(userName.text,email.text,password.text)
                        }
                        context.startActivity(Intent(context, LoginActivity::class.java))
                    }catch (error:Exception){
                        Log.e("TAG Register error","Register Failed")
                    }
                    }
                })
            }
            Row{
                Button(modifier = Modifier.width(200.dp),content ={Text(text="Login")} ,onClick = {
                    // navigate to login Activity
                    context.startActivity(Intent(context, LoginActivity::class.java))
                })
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun UserRegisterFormPreview(){
    UserRegisterForm(RegisterUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )

}