package com.patinfly

import android.content.Intent
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.user.UserDataSource
import com.patinfly.data.repository.UserRepository
import com.patinfly.domain.model.User
import com.patinfly.domain.usecase.ProfileDataUsecase
import com.patinfly.presentation.rentList.RentListActivity
import com.patinfly.presentation.scooterList.ScooterListActivity
import kotlinx.coroutines.launch

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
                                ProfileScreen(email,ProfileDataUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )
                }
            }
        }

    }


}



@Composable
 fun ProfileScreen(loginEmail:String?,profileDataUsecase: ProfileDataUsecase){
    val coroutineScope = rememberCoroutineScope()
    var user by remember { mutableStateOf<User?>(null) }

    LaunchedEffect(loginEmail) {
        coroutineScope.launch {
            val fetchedUser = loginEmail?.let { profileDataUsecase.execute(it) }
            user = fetchedUser
        }
    }
    val context = LocalContext.current
    val scrollState= rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(8.dp)
        ) {
            val userInfo = listOf(
                "UUID" to user?.uuid.toString(),
                "Username" to user?.username.toString(),
                "Email" to user?.email.toString(),
                "Is Renting" to user?.isRenting.toString(),
                "Scooter Rented" to user?.scooterRented.toString(),
                "Creation Date" to user?.creationDate.toString(),
                "Number of Rents" to user?.numberOfRents.toString()
            )

            userInfo.forEach { (label, value) ->
                UserInfoRow(label = label, value = value)
            }

            Spacer(modifier = Modifier.height(16.dp))

            ActionButton(
                text = "Scooters",
                onClick = {
                    context.startActivity(Intent(context, ScooterListActivity::class.java))
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            ActionButton(
                text = "Rents",
                onClick = {
                    context.startActivity(Intent(context, RentListActivity::class.java))
                }
            )
           }
        }
}
@Composable
fun UserInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.width(150.dp)
        )
        TextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 8.dp),
            singleLine = true
        )
    }
}

@Composable
fun ActionButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 16.dp),
        content = {
            Text(text = text)
            }
        )
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen("email",ProfileDataUsecase((UserRepository(UserDataSource.getInstance(LocalContext.current),AppDatabase.getDatabase(LocalContext.current).userDataSource(),AppDatabase.getDatabase(LocalContext.current).scooterDataSource())))                    )

}