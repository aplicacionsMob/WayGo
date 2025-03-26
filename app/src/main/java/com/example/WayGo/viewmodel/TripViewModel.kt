package com.example.WayGo.viewmodel

import com.example.WayGo.model.Trip
import com.example.WayGo.repository.TripRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TripViewModel {
    private val repository = TripRepository()
    private val _trips = MutableStateFlow<List<Trip>>(emptyList())
    val trips: StateFlow<List<Trip>> get() = _trips

    init {
        _trips.value = repository.getTrips()
    }

    fun addTrip(trip: Trip) {
        repository.addTrip(trip)
        _trips.value = repository.getTrips()
    }

    fun editTrip(updatedTrip: Trip) {
        repository.editTrip(updatedTrip)
        _trips.value = repository.getTrips()
    }

    fun deleteTrip(tripId: String) {
        repository.deleteTrip(tripId)
        _trips.value = repository.getTrips()
    }
}