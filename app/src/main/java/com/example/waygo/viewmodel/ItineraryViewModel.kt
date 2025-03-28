package com.example.waygo.viewmodel

//afegim aquests imports per a poder fer servir les funcions de data
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.waygo.model.ItineraryItem
import java.util.UUID

class ItineraryViewModel : ViewModel() {

    private val _itineraryItems = MutableStateFlow<List<ItineraryItem>>(emptyList())
    val itineraryItems: StateFlow<List<ItineraryItem>> = _itineraryItems

    fun addActivity(description: String, date: String, location: String) {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val parsedDate: Date = dateFormat.parse(date) ?: Date() // Evita errors amb dates incorrectes

        val newItem = ItineraryItem(
            id = UUID.randomUUID().toString(),
            description = description,
            date = parsedDate,
            location = location
        )
        _itineraryItems.value += newItem
    }

    fun updateActivity(itemId: String, newDescription: String, newDate: String, newLocation: String) {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val parsedDate: Date = dateFormat.parse(newDate) ?: Date()

        _itineraryItems.value = _itineraryItems.value.map { item ->
            if (item.id == itemId) item.copy(description = newDescription, date = parsedDate, location = newLocation)
            else item
        }
    }

    fun deleteActivity(itemId: String) {
        _itineraryItems.value = _itineraryItems.value.filter { it.id != itemId }
    }
}
