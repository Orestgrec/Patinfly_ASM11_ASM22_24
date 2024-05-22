package com.patinfly.presentation.rentList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.patinfly.data.dataSource.dbDataSource.AppDatabase
import com.patinfly.data.dataSource.rent.RentDataSource
import com.patinfly.data.dataSource.scooter.ScooterDataSource
import com.patinfly.data.repository.RentRepository
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.domain.usecase.GetRentsUsecase
import com.patinfly.domain.usecase.GetScooterUsecase
import com.patinfly.presentation.rentList.ui.theme.PatinflyTheme
import com.patinfly.presentation.scooterList.ScooterViewModel

class RentListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: RentViewModel = RentViewModel(
                        GetRentsUsecase(
                        )
                    )
                    RentListScreen(context = this.applicationContext, viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PatinflyTheme {
        Greeting2("Android")
    }
}