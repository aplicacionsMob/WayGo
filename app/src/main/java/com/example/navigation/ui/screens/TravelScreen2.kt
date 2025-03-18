package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Travel2(
    val tripName: String,
    val destinations: List<String>,
    val startDate: String,
    val endDate: String,
    val participants: List<String>
)

@Composable
fun TravelScreen2(navController: NavController) {
    val travel = Travel2(
        tripName = "Winter Vacation",
        destinations = listOf("Croacia"),
        startDate = "2025-01-15",
        endDate = "2025-01-30",
        participants = listOf("Alice", "Bob")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Trip Details")
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Trip Name: ${travel.tripName}")
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Destinations:")
        LazyColumn {
            items(travel.destinations) { destination ->
                Text(text = destination, modifier = Modifier.padding(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Start Date: ${travel.startDate}")
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "End Date: ${travel.endDate}")
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Participants:")
        LazyColumn {
            items(travel.participants) { participant ->
                Text(text = participant, modifier = Modifier.padding(8.dp))
            }
        }
        Button(onClick = {
            navController.navigate("home") {
                popUpTo("back") { inclusive = true }
            }
        }) {
            Text(text = "Back")
        }
    }
}