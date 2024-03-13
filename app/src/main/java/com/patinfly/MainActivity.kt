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
import com.patinfly.data.model.RentModel
import com.patinfly.data.model.ScooterModel
import com.patinfly.data.model.UserModel
import com.patinfly.presentaion.theme.PatinflyTheme
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

class MainActivity : ComponentActivity() {
   private val tag = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "Before setContent Execution")
        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("And")
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.e(tag, "On Start")

        val currentDate=LocalDateTime.now()

        val userID = UUID.randomUUID()
        val rentId = UUID.randomUUID()
        val scooterID = UUID.randomUUID()

        val rent = RentModel(uuid = rentId, scooterUUID = scooterID, userUUID =userID, startDate ="2018-12-12",stopDate="2018-12-12" )
        val user = UserModel(uuid =userID, username = "samuel", email = "samuel@gmail.com", isRenting = true, scooterRented =scooterID , creationDate =currentDate, numberOfRents = 3 )
        val scooter = ScooterModel(uuid=scooterID, model = "audi", serialNumber = "FE52186", longitude =8795413221.0,latitude=45213186.0,vacant=false,batteryLevel=50.0,batteryPartNumber="battery",lastMaintenance=null)

    }
    override fun onResume() {
        super.onResume()
        Log.e(tag, "On Resume")

    }
    override fun onStop() {
        super.onStop()
        Log.d(tag, "On Stop")

    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag, "On Destroy")

    }
    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "On Restart")

    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello from $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PatinflyTheme {
        Greeting("Androd")
    }
}