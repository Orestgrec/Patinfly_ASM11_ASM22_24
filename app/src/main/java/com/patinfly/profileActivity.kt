package com.patinfly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.patinfly.ui.theme.PatinflyTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class profileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    ProfileScreen()
                }
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(){
    var uuid by rememberSaveable { mutableStateOf("default uuid") }
    var username by rememberSaveable { mutableStateOf("default username") }
    var email by rememberSaveable { mutableStateOf("default email") }
    var isRenting by rememberSaveable { mutableStateOf("default isRenting") }
    var scooterRented by rememberSaveable { mutableStateOf("default scooterRented") }
    var creationDate by rememberSaveable { mutableStateOf("default creationDate") }
    var numberOfRents by rememberSaveable { mutableStateOf("default numberOfRents") }


    Surface {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "uuid", modifier = Modifier.width(100.dp))
                TextField(
                    value = uuid,
                    onValueChange = {uuid = it},
                    /*
                    colors = textFieldColors(
                        background
                    )
                     */
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "username", modifier = Modifier.width(100.dp))
                TextField(
                    value = username,
                    onValueChange = {username = it},
                    /*
                    colors = textFieldColors(
                        background
                    )
                     */
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "email", modifier = Modifier.width(100.dp))
                TextField(
                    value = email,
                    onValueChange = {email = it},
                    /*
                    colors = textFieldColors(
                        background
                    )
                     */
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "isRenting", modifier = Modifier.width(100.dp))
                TextField(
                    value = isRenting,
                    onValueChange = {isRenting = it},
                    /*
                    colors = textFieldColors(
                        background
                    )
                     */
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "scooterRented", modifier = Modifier.width(100.dp))
                TextField(
                    value = scooterRented,
                    onValueChange = {scooterRented = it},
                    /*
                    colors = textFieldColors(
                        background
                    )
                     */
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "creationDate", modifier = Modifier.width(100.dp))
                TextField(
                    value = creationDate,
                    onValueChange = {creationDate = it},
                    /*
                    colors = textFieldColors(
                        background
                    )
                     */
                )
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "numberOfRents", modifier = Modifier.width(100.dp))
                TextField(
                    value = numberOfRents,
                    onValueChange = {numberOfRents = it},
                    /*
                    colors = textFieldColors(
                        background
                    )
                     */
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PatinflyTheme {
        ProfileScreen()
    }
}




//questa è per vedere in tempo reale le modifiche all'interfaccia
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}