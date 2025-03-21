package com.example.navigation.model

import java.util.Date

data class Trip(
    val id: String,
    val destination: String,
    val startDate: Date,
    val endDate: Date,
    val budget: Double,
    val itinerary: List<ItineraryItem> = emptyList(),
    val photos: List<Photo> = emptyList()
)

//sprint2
