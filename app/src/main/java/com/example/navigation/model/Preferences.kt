package com.example.navigation.model

data class Preferences(
    val id: String,
    val notificationsEnabled: Boolean = true,
    val preferredLanguage: String = "en",
    val theme: String = "light"
)
