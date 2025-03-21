package com.example.WayGo.repository

import com.example.WayGo.model.ItineraryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItineraryRepository {
    private val _itineraryItems = MutableStateFlow<List<ItineraryItem>>(emptyList())
    val itineraryItems: StateFlow<List<ItineraryItem>> get() = _itineraryItems

    fun addActivity(activity: ItineraryItem) {
        _itineraryItems.value = _itineraryItems.value + activity
    }

    fun updateActivity(updatedActivity: ItineraryItem) {
        _itineraryItems.value = _itineraryItems.value.map {
            if (it.id == updatedActivity.id) updatedActivity else it
        }
    }

    fun deleteActivity(activityId: String) {
        _itineraryItems.value = _itineraryItems.value.filter { it.id != activityId }
    }
}
