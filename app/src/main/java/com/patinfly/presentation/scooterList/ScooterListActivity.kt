package com.patinfly.presentation.scooterList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.patinfly.domain.usecase.GetScooterUsecase
import com.patinfly.domain.usecase.InsertScooterUsecase
import com.patinfly.presentation.scooterList.ui.theme.PatinflyTheme


class ScooterListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PatinflyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val viewModel = ScooterViewModel(GetScooterUsecase(
                    ), InsertScooterUsecase()
                    )
                    ScooterListScreen(context = this.applicationContext, viewModel = viewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScooterListPreview() {
    PatinflyTheme {

    }
}