package com.example.waygo.model

import com.example.navigation.model.ItineraryItem

data class Trip(
    val id: String,
    var destination: String,
    var startDate: String, // Es podria canviar a Date si es treballa amb dates
    var endDate: String,
    var budget: Double,
    val itinerary: MutableList<ItineraryItem> = mutableListOf()
) {
    fun addItineraryItem(item: ItineraryItem) {
        itinerary.add(item)
    }

    fun removeItineraryItem(itemId: String) {
        itinerary.removeIf { it.id == itemId }
    }

    fun updateTripDetails(newDestination: String, newStartDate: String, newEndDate: String, newBudget: Double) {
        destination = newDestination
        startDate = newStartDate
        endDate = newEndDate
        budget = newBudget
    }
}
