package com.example.navigation.model

data class ItineraryItem(
    val id: String,
    var description: String,
    var date: String, // Es podria canviar a Date
    var location: String
)
