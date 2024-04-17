package com.patinfly.presentaion.scooterList

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun ScooterListScreen(context: Context, viewModel: ScooterViewModel)
{
    val scooterList by viewModel.scooters.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.fetchScooters(context)
    }
    Column {
        if (scooterList.isEmpty()) {
    // Show loading indicator or placeholder
     Text(text = "Loading...")        } else {
     // Display the list of credit cards
      Column { scooterList.forEach { ScooterCardItem(scooter = it)  }  }}} }
