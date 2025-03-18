package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TravelCreatorScreen(navController: NavController) {
    var tripName by remember { mutableStateOf("") }
    var destinations by remember { mutableStateOf("") }
    var travelDates by remember { mutableStateOf("") }
    var participants by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Create a Trip")
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = tripName,
            onValueChange = { tripName = it },
            label = { Text("Trip Name") }
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = destinations,
            onValueChange = { destinations = it },
            label = { Text("Destinations") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = travelDates,
            onValueChange = { travelDates = it },
            label = { Text("Travel Dates") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = participants,
            onValueChange = { participants = it },
            label = { Text("Participants") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("home") {
            popUpTo("saveTrip") { inclusive = true }
        } }) {
            Text(text = "Save Trip")
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