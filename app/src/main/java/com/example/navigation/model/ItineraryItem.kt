package com.example.navigation.model

data class ItineraryItem(
    val id: String,
    var description: String,
    var date: String, // També es podria usar Date
    var location: String
) {
    fun updateItemDetails(newDescription: String, newDate: String, newLocation: String) {
        description = newDescription
        date = newDate
        location = newLocation
    }
}
