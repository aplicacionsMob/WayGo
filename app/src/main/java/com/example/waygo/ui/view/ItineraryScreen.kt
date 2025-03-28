package com.example.waygo.ui.view

import androidx.lifecycle.viewmodel.compose.viewModel //solució per a l'error: Expression 'viewModel' of type 'ItineraryViewModel' cannot be invoked as a function. The function 'invoke()' is not found

//aquests 3 imports son per convertir un String a Date
import java.text.SimpleDateFormat
import java.util.Locale

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.waygo.domain.model.ItineraryItem
import com.example.waygo.ui.viewmodel.ItineraryViewModel
import java.util.UUID

@Composable
fun ItineraryScreen(viewModel: ItineraryViewModel = viewModel()) {
    val itineraryItems by viewModel.itineraryItems.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {

            //afegim aquesta línia per a poder convertir un String a Date
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

            val newActivity = ItineraryItem(
                id = UUID.randomUUID().toString(),
                description = "Nova Activitat",
                date = dateFormat.parse("2025-01-01")!!, // Converteix String a Date
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
