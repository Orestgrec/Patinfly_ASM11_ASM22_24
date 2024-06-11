package com.patinfly.presentation.scooterList

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.patinfly.domain.model.Scooter
import com.patinfly.domain.usecase.GetSingleScooterUsercase
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment
@Composable
fun ScooterInfo(uuid :String?,getSingleScooterUsercase: GetSingleScooterUsercase) {

    val coroutineScope = rememberCoroutineScope()
    var scooter by remember { mutableStateOf<Scooter?>(null) }

    LaunchedEffect(uuid) {
        Log.e("TAG check single",uuid.toString())

        coroutineScope.launch {
            val fetchedScooter = uuid?.let { getSingleScooterUsercase.execute(it) }
            scooter = fetchedScooter
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            Text(
                text = "Scooter Details",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(),
                fontWeight = FontWeight.Bold
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Info, contentDescription = "UUID")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "UUID: ${scooter?.uuid}", style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Face, contentDescription = "Model")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Model: ${scooter?.model}", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Call, contentDescription = "Serial Number")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Serial Number: ${scooter?.serialNumber}", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = "Location")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Location: (${scooter?.latitude}, ${scooter?.longitude})", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.CheckCircle, contentDescription = "Vacant")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Vacant: ${if (scooter?.vacant == true) "Yes" else "No"}", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Menu, contentDescription = "Battery Level")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Battery Level: ${scooter?.batteryLevel}%", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Notifications, contentDescription = "Battery Part Number")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Battery Part Number: ${scooter?.batteryPartNumber}", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.DateRange, contentDescription = "Last Maintenance")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Last Maintenance: ${scooter?.lastMaintenance ?: "None"}", style = MaterialTheme.typography.bodyLarge)
            }
           }
        }
}