package com.patinfly

import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.patinfly.data.dataSource.user.UserDao
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.usecase.ProfileDataUsecase
import org.json.JSONArray
import java.io.InputStream
import java.nio.charset.StandardCharsets

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val email:String? = intent.getStringExtra("email")

        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                        ProfileScreen(email,ProfileDataUsecase((UserRepository(UserDao.getInstance(LocalContext.current,loadJson())))))
                }
            }
        }

    }

    private fun loadJson(): JSONArray?{
        return try {
            val inputStream: InputStream = assets.open("user.json")
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
fun ProfileScreen(loginEmail:String?,profileDataUsecase: ProfileDataUsecase){
    val uuid by rememberSaveable { mutableStateOf(profileDataUsecase.execute(loginEmail)?.uuid.toString()) }
    val username by rememberSaveable { mutableStateOf(profileDataUsecase.execute(loginEmail)?.username) }
    val email by rememberSaveable { mutableStateOf(profileDataUsecase.execute(loginEmail)?.email) }
    val isRenting by rememberSaveable { mutableStateOf(profileDataUsecase.execute(loginEmail)?.isRenting.toString()) }
    val scooterRented by rememberSaveable { mutableStateOf(profileDataUsecase.execute(loginEmail)?.scooterRented.toString()) }
    val creationDate by rememberSaveable { mutableStateOf(profileDataUsecase.execute(loginEmail)?.creationDate.toString()) }
    val numberOfRents by rememberSaveable { mutableStateOf(profileDataUsecase.execute(loginEmail)?.numberOfRents.toString()) }

    // receive data
    Log.e("profileTag","the wanted test email is ${profileDataUsecase.execute(loginEmail)}")

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
                    onValueChange = {},
                    readOnly = true
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "username", modifier = Modifier.width(100.dp))
                username?.let { 
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "email", modifier = Modifier.width(100.dp))
                email?.let {
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "isRenting", modifier = Modifier.width(100.dp))
                TextField(
                    value = isRenting,
                    onValueChange = {},
                    readOnly = true
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
                    onValueChange = {},
                    readOnly = true

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
                    onValueChange = {},
                    readOnly = true

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
                    onValueChange = {},
                    readOnly = true

                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    val jsonArray:JSONArray?=null
    ProfileScreen("email",ProfileDataUsecase((UserRepository(UserDao.getInstance(LocalContext.current,jsonArray)))))
}