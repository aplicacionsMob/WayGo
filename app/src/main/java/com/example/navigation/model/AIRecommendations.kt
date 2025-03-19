package com.example.navigation.model

data class AIRecommendations(
    val recommendationId: String,
    val tripId: String,
    val suggestedActivity: String,
    val rating: Double
) {
    fun generateRecommendations() {
        // Aquí es podria connectar amb una IA o API
    }

    fun rateRecommendation(newRating: Double) {
        // Actualitzar la puntuació
    }
}
