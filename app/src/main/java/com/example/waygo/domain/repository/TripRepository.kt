package com.example.waygo.domain.model.repository

import com.example.waygo.domain.model.Trip

class TripRepository {
    private val trips = mutableListOf<Trip>()

    fun getTrips(): List<Trip> = trips

    fun addTrip(trip: Trip) {
        trips.add(trip)
    }

    fun editTrip(updatedTrip: Trip) {
        val index = trips.indexOfFirst { it.id == updatedTrip.id }
        if (index != -1) {
            trips[index] = updatedTrip
        }
    }

    fun deleteTrip(tripId: String) {
        trips.removeAll { it.id == tripId }
    }
}