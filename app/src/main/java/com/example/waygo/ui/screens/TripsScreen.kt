package com.example.waygo.ui.screens

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.waygo.model.Trip
import com.example.waygo.viewmodel.TripViewModel

@Composable
fun TripsScreen(viewModel: TripViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val trips by viewModel.trips.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val startDateParsed = dateFormat.parse("2025-01-01") ?: Date()
            val endDateParsed = dateFormat.parse("2025-01-10") ?: Date()

            val startDateString = dateFormat.format(startDateParsed)
            val endDateString = dateFormat.format(endDateParsed)

            viewModel.addTrip("Nova Destinació", startDateString, endDateString, 1500.0)
        }) {
            Text("Afegir Viatge")
        }


        LazyColumn {
            items(trips) { trip ->
                TripItem(trip,
                    onDelete = { viewModel.deleteTrip(trip.id) },
                    onEdit = { viewModel.editTrip(trip.id, "Actualitzat", "2025-07-01", "2025-07-15", 1500.0) }
                )
            }
        }
    }
}

@Composable
fun TripItem(trip: Trip, onDelete: () -> Unit, onEdit: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = trip.destination, style = MaterialTheme.typography.titleLarge)
            Text(text = "${trip.startDate} - ${trip.endDate}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Pressupost: ${trip.budget}€", style = MaterialTheme.typography.bodyMedium)

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("✏️ Edita", modifier = Modifier.clickable { onEdit() })
                Text("🗑️ Elimina", modifier = Modifier.clickable { onDelete() })
            }
        }
    }
}
