package com.example.waygo.ui.screens


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
import java.util.UUID

@Composable
fun TripsScreen(viewModel: TripViewModel = viewModel()) {
    val trips by viewModel.trips.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {
            val newTrip = Trip(
                id = UUID.randomUUID().toString(),
                destination = "Nova Destinació",
                startDate = "2025-01-01",
                endDate = "2025-01-10",
                budget = 1500.0
            )
            viewModel.addTrip(newTrip)
        }) {
            Text("Afegir Viatge")
        }

        LazyColumn {
            items(trips) { trip ->
                TripItem(trip, onDelete = { viewModel.deleteTrip(trip.id) })
            }
        }
    }
}

@Composable
fun TripItem(trip: Trip, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = trip.destination, style = MaterialTheme.typography.titleLarge)
            Text(text = "${trip.startDate} - ${trip.endDate}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Pressupost: ${trip.budget}€", style = MaterialTheme.typography.bodyMedium)

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("✏️ Edita", modifier = Modifier.clickable { /* Implementa editar */ })
                Text("🗑️ Elimina", modifier = Modifier.clickable { onDelete() })
            }
        }
    }
}
