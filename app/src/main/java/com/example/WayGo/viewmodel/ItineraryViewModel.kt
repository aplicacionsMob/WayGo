package com.example.WayGo.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.WayGo.model.ItineraryItem
import java.util.UUID

class ItineraryViewModel : ViewModel() {

    private val _itineraryItems = MutableStateFlow<List<ItineraryItem>>(emptyList())
    val itineraryItems: StateFlow<List<ItineraryItem>> = _itineraryItems

    fun addActivity(description: String, date: String, location: String) {
        val newItem = ItineraryItem(
            id = UUID.randomUUID().toString(),
            description = description,
            date = date,
            location = location
        )
        _itineraryItems.value += newItem
    }

    fun updateActivity(itemId: String, newDescription: String, newDate: String, newLocation: String) {
        _itineraryItems.value = _itineraryItems.value.map { item ->
            if (item.id == itemId) item.copy(description = newDescription, date = newDate, location = newLocation)
            else item
        }
    }

    fun deleteActivity(itemId: String) {
        _itineraryItems.value = _itineraryItems.value.filter { it.id != itemId }
    }
}
