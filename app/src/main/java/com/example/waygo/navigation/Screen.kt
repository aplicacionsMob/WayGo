package com.example.waygo.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object About : Screen("about")
    data object Login : Screen("login")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object Version : Screen("version")
    data object Trip : Screen("trip")
    data object Itinerary : Screen("itinerary")
}
