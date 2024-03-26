package com.patinfly.ui.theme.ui.theme

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.google.gson.Gson
import com.patinfly.MainActivity
import com.patinfly.RegisterActivity
import com.patinfly.data.dataSource.user.userDao
import com.patinfly.data.model.UserModel
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.usecase.LoginUsecase
import com.patinfly.utils.ReadJSONFromAssets

class LoginActivity :ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        val gson =Gson()
        val jsonString= ReadJSONFromAssets(baseContext,"user.json")
        val data = gson.fromJson(jsonString,UserModel::class.java)
*/

        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserLoginForm(LoginUsecase((UserRepository(userDao.getinstance(LocalContext.current)))))
                }
            }
        }
    }
}

@Composable
fun UserLoginForm(loginUsecase: LoginUsecase){
    val context = LocalContext.current

    Surface {
        Column (modifier = Modifier.width(300.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            var email by remember {
                mutableStateOf(TextFieldValue("")) }
            var password by remember {
                mutableStateOf(TextFieldValue("")) }
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                TextField(value = email, label = { Text(text="email") } , onValueChange ={email= it}, )
            }
            Row (modifier = Modifier.padding(vertical = 8.dp)){
                TextField(value = password, label = { Text(text="Password") } , onValueChange ={password= it}, )


            }
            Row{
                Button(modifier = Modifier.width(200.dp),content ={Text(text="Login")} ,onClick = {
                   /*TODO*/
                    if(true){
                    context.startActivity(Intent(context, MainActivity::class.java))
                    }
                })}
            Row{
                Button(modifier = Modifier.width(200.dp),content ={Text(text="Register")} ,onClick = {
                    context.startActivity(Intent(context, RegisterActivity::class.java))
                })
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun UserLoginFormPreview(){
    UserLoginForm(LoginUsecase((UserRepository(userDao.getinstance(LocalContext.current)))))
}