package com.example.WayGo.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.WayGo.model.ItineraryItem
import com.example.WayGo.viewmodel.ItineraryViewModel
import java.util.UUID

@Composable
fun ItineraryScreen(viewModel: ItineraryViewModel = viewModel()) {
    val itineraryItems by viewModel.itineraryItems.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {
            val newActivity = ItineraryItem(
                id = UUID.randomUUID().toString(),
                description = "Nova Activitat",
                date = "2025-01-01",
                location = "Barcelona"
            )

        }) {
            Text("Afegir Activitat")
        }

        LazyColumn {
            items(itineraryItems) { activity ->
                ItineraryItemCard(activity, onDelete = { viewModel.deleteActivity(activity.id) })
            }
        }
    }
}

@Composable
fun ItineraryItemCard(activity: ItineraryItem, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = activity.description, style = MaterialTheme.typography.titleLarge)
            Text(text = "Data: ${activity.date}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Lloc: ${activity.location}", style = MaterialTheme.typography.bodyMedium)

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("✏️ Edita", modifier = Modifier.clickable { /* Implementa editar */ })
                Text("🗑️ Elimina", modifier = Modifier.clickable { onDelete() })
            }
        }
    }
}
