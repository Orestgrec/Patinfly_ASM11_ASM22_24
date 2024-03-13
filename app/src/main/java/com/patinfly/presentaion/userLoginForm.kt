package com.patinfly.presentaion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun UserLoginForm(){
    Surface {
    Column (modifier = Modifier.width(300.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        var email by remember {
            mutableStateOf(TextFieldValue("")) }
        var password by remember {
            mutableStateOf(TextFieldValue("")) }
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            TextField(value = email, label = { Text(text="Username") } , onValueChange ={email= it}, )
        }
        Row (modifier = Modifier.padding(vertical = 8.dp)){
            TextField(value = password, label = { Text(text="Password") } , onValueChange ={password= it}, )


        }
        Row{
           Button(modifier = Modifier.width(200.dp),content ={Text(text="Login")} ,onClick = { /*TODO*/ })
        }
        Row{
            Button(modifier = Modifier.width(200.dp),content ={Text(text="Register")} ,onClick = { /*TODO*/ })
        }
        }
    }
    }


@Preview(showBackground = true)
@Composable
fun UserLoginFormPreview(){
    UserLoginForm()
}





