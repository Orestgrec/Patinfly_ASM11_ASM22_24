package com.patinfly

import android.content.Intent
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
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.user.UserDataSource
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.dbDatasource.UserEntity
import com.patinfly.domain.usecase.ProfileDataUsecase
import com.patinfly.presentation.rentList.RentListActivity
import com.patinfly.presentation.scooterList.ScooterListActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.io.InputStream
import java.nio.charset.StandardCharsets

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val email: String? = intent.getStringExtra("email")

        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
//                    ProfileScreen(email,
//                        ProfileDataUsecase((UserRepository(
//                        UserDataSource.getInstance(LocalContext.current, AppDatabase.getDatabase(
//                            LocalContext.current).userDataSource()))))

                                ProfileScreen(email,ProfileDataUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )


                }
            }
        }

    }

    // load data from json file in assets and return json Array
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
    val uuid by rememberSaveable { mutableStateOf(loginEmail?.let {
            profileDataUsecase.execute(it)?.uuid.toString()
    }) }
    val username by rememberSaveable { mutableStateOf(loginEmail?.let {
        profileDataUsecase.execute(
            it
        )?.username
    }) }
    val email by rememberSaveable { mutableStateOf(loginEmail?.let { profileDataUsecase.execute(it)?.email }) }
    val isRenting by rememberSaveable { mutableStateOf(loginEmail?.let {
        profileDataUsecase.execute(
            it
        )?.isRenting.toString()
    }) }
    val scooterRented by rememberSaveable { mutableStateOf(loginEmail?.let {
        profileDataUsecase.execute(
            it
        )?.scooterRented.toString()
    }) }
    val creationDate by rememberSaveable { mutableStateOf(loginEmail?.let {
        profileDataUsecase.execute(
            it
        )?.creationDate.toString()
    }) }
    val numberOfRents by rememberSaveable { mutableStateOf(loginEmail?.let {
        profileDataUsecase.execute(
            it
        )?.numberOfRents.toString()
    }) }

    val context = LocalContext.current


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
                Text(text = "uuid", modifier = Modifier.width(150.dp))
                uuid?.let {
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.width(250.dp)

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "username", modifier = Modifier.width(150.dp))
                username?.let { 
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.width(250.dp)

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "email", modifier = Modifier.width(150.dp))
                email?.let {
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.width(250.dp)

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "isRenting", modifier = Modifier.width(150.dp))
                isRenting?.let {
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.width(250.dp)

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "scooterRented", modifier = Modifier.width(150.dp))
                scooterRented?.let {
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier.width(250.dp)

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "creationDate", modifier = Modifier.width(150.dp))
                creationDate?.let {
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true ,
                        modifier = Modifier.width(250.dp)

                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "numberOfRents", modifier = Modifier.width(150.dp))
                numberOfRents?.let {
                    TextField(
                        value = it,
                        onValueChange = {},
                        readOnly = true ,
                        modifier = Modifier.width(250.dp)
                    )
                }
            }
            Row (

            ){
                Button( modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp).padding(vertical = 30.dp),content ={Text(text="Go Back")} ,onClick = {
                    // navigate to login Activity
                    context.startActivity(Intent(context, LoginActivity::class.java))
                })
            }
            Row (

            ){
                Button( modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp).padding(vertical = 30.dp),content ={Text(text="Scooters")} ,onClick = {
                    // navigate to ScooterListActivity
                    context.startActivity(Intent(context, ScooterListActivity::class.java))
                })
            }
            Row (

            ){
                Button( modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp).padding(vertical = 30.dp),content ={Text(text="Rents")} ,onClick = {
                    // navigate to ScooterListActivity
                    context.startActivity(Intent(context, RentListActivity::class.java))
                })
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    val jsonArray:JSONArray?=null
    ProfileScreen("email",ProfileDataUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )

}