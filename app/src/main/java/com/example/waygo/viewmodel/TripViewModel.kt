package com.example.waygo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.waygo.model.Trip
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class TripViewModel : ViewModel() {

    private val _trips = MutableStateFlow<List<Trip>>(emptyList())
    val trips: StateFlow<List<Trip>> = _trips

    // Afegir un nou viatge
    fun addTrip(destination: String, startDate: String, endDate: String, budget: Double) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val parsedStartDate: Date = dateFormat.parse(startDate) ?: Date()
        val parsedEndDate: Date = dateFormat.parse(endDate) ?: Date()

        val newTrip = Trip(
            id = UUID.randomUUID().toString(),
            destination = destination,
            startDate = parsedStartDate,
            endDate = parsedEndDate,
            budget = budget
        )

        _trips.value = _trips.value + newTrip
        Log.d("TripViewModel", "Viatge afegit: $newTrip") // DEBUG
    }


    // Editar un viatge existent
    fun editTrip(tripId: String, newDestination: String, newStartDate: String, newEndDate: String, newBudget: Double) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val parsedStartDate: Date = dateFormat.parse(newStartDate) ?: Date()
        val parsedEndDate: Date = dateFormat.parse(newEndDate) ?: Date()

        _trips.value = _trips.value.map { trip ->
            if (trip.id == tripId) {
                trip.copy(
                    destination = newDestination,
                    startDate = parsedStartDate,
                    endDate = parsedEndDate,
                    budget = newBudget
                )
            } else trip
        }
    }

    // Eliminar un viatge
    fun deleteTrip(tripId: String) {
        _trips.value = _trips.value.filter { it.id != tripId }
    }
}
