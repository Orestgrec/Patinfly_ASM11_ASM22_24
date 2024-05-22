package com.patinfly.presentation.scooterList

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.patinfly.LoginActivity
import com.patinfly.ProfileActivity
import com.patinfly.presentation.rentList.RentListActivity

@Composable
fun ScooterListScreen(context: Context, viewModel: ScooterViewModel)
{
    val scooterList by viewModel.scooters.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.fetchScooters(context)
    }

    Column {
        if (scooterList.isEmpty()) {
     //Show loading indicator or placeholder
     Text(text = "Loading...")        } else {
      //Display the list of credit cards
      Column(
          modifier = Modifier
              .verticalScroll(rememberScrollState())
              .width(300.dp) // Example width to limit the Column's width
      ) { scooterList.forEach { ScooterCardItem(scooter = it)  }  }
     }
        Row (

        ){
            Button( modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp).padding(vertical = 30.dp),content ={Text(text="GO back")} ,onClick = {
                // navigate to ScooterListActivity
                context.startActivity(Intent(context, LoginActivity::class.java))
            })
        }
}

}
