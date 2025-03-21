package com.example.navigation.model

data class Trip(
    val id: String,
    val destination: String,
    val startDate: String,
    val endDate: String,
    val budget: Double,
    val itinerary: List<ItineraryItem> = emptyList(),
    val photos: List<Photo> = emptyList()
)
