package com.example.waygo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.waygo.ui.screens.AboutScreen
import com.example.waygo.ui.screens.LoginScreen
import com.example.waygo.ui.screens.ProfileScreen
import com.example.waygo.ui.screens.SettingsScreen
import com.example.waygo.ui.screens.VersionScreen
import com.example.waygo.ui.screens.HomeScreen
import com.example.waygo.ui.screens.TripScreen
import com.example.waygo.ui.screens.ItineraryScreen


@Composable
fun NavGraph(navController: NavHostController) {
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
