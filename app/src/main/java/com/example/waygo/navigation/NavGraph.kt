package com.example.waygo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import com.example.waygo.ui.screens.*

@Composable
fun NavGraph(navController: NavController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.About.route) { AboutScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Version.route) { VersionScreen(navController) }
        composable(Screen.Trip.route) { TripScreen(navController) }
        composable(Screen.Itinerary.route) { ItineraryScreen(navController) }
    }
}
