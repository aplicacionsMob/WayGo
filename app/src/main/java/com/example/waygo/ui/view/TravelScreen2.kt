package com.example.waygo.ui.view

import com.example.waygo.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
        Text(text = stringResource(id = R.string.trip_details))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = stringResource(id = R.string.trip_name, travel.tripName))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = stringResource(id = R.string.destinations))
        LazyColumn {
            items(travel.destinations) { destination ->
                Text(text = destination, modifier = Modifier.padding(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = stringResource(id = R.string.start_date, travel.startDate))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = stringResource(id = R.string.end_date, travel.endDate))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = stringResource(id = R.string.participants))
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
            Text(text = stringResource(id = R.string.back))
        }
    }
}