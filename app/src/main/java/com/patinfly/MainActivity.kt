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
import com.patinfly.data.repository.RentRepository
import com.patinfly.domain.model.Rent
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.model.User
import com.patinfly.presentaion.theme.PatinflyTheme
import java.time.LocalDateTime
import java.util.UUID

class MainActivity constructor(private val rentRepository: RentRepository) : ComponentActivity() {
   private val tag = MainActivity::class.java.simpleName

    private fun createInstance (){
        val currentDate=LocalDateTime.now()
        val userID = UUID.randomUUID()
        val rentId = UUID.randomUUID()
        val scooterID = UUID.randomUUID()

        val rent = Rent(uuid = rentId, scooterUUID = scooterID, userUUID =userID, startDate ="2018-12-12",stopDate="2018-12-12" )
        val user = User(uuid =userID, username = "samuel", email = "samuel@gmail.com", isRenting = true, scooterRented =scooterID , creationDate =currentDate, numberOfRents = 3 )
        val scooter = Scooter(uuid=scooterID, model = "audi", serialNumber = "FE52186", longitude =8795413221.0,latitude=45213186.0,vacant=false,batteryLevel=50.0,batteryPartNumber="battery",lastMaintenance=null)

        rentRepository.saveRent(rent)
        //val rentList :List<Rent> =  rentRepository.fetchRents()
        //scooterIN.saveScooter(scooter)

        //userIN.saveUser(user)

    }
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