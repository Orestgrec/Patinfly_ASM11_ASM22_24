package com.patinfly.presentation.scooterList

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScooterListScreen(context: Context, viewModel: ScooterViewModel)
{
    val scooterList by viewModel.scooters.observeAsState(emptyList())
    val test by viewModel.test.observeAsState()



    LaunchedEffect(Unit) {
        viewModel.fetchScooters(context)
    }

    Column {
        if (scooterList?.isEmpty() == true) {
     //Show loading indicator or placeholder
     Text(text = "Loading...")        } else {
      //Display the list of credit cards
      Column(
          modifier = Modifier
              .verticalScroll(rememberScrollState())
              .width(300.dp) // Example width to limit the Column's width
      ) { scooterList?.forEach { ScooterCardItem(scooter = it)  } }
     }
}

}
