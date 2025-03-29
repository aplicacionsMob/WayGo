package com.example.waygo.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("about")
    object Login : Screen("login")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object Version : Screen("version")
    object Trip : Screen("trip")
    object Itinerary : Screen("itinerary")
}
