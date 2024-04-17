package com.patinfly.presentaion.scooterList

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.patinfly.domain.model.Scooter

@Composable
fun ScooterCardItem(scooter: Scooter){
    Surface {
        Card(
            modifier =  Modifier.fillMaxWidth().padding(16.dp),
        )
        {}
    }


}
