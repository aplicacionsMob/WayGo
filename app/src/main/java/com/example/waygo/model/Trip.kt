package com.example.waygo.model

import java.util.Date

data class Trip(
    val id: String,
    val destination: String,
    val startDate: Date,
    val endDate: Date,
    val budget: Double
)
