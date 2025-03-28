package com.example.waygo.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.waygo.R

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
        Text(text = stringResource(id = R.string.create_trip))
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = tripName,
            onValueChange = { tripName = it },
            label = { Text(stringResource(id = R.string.trip_name)) }
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = destinations,
            onValueChange = { destinations = it },
            label = { Text(stringResource(id = R.string.destinations)) }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = travelDates,
            onValueChange = { travelDates = it },
            label = { Text(stringResource(id = R.string.travel_dates)) }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = participants,
            onValueChange = { participants = it },
            label = { Text(stringResource(id = R.string.participants)) }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("home") {
            popUpTo("saveTrip") { inclusive = true }
        } }) {
            Text(text = stringResource(id = R.string.save_trip))
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