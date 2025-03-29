package com.example.waygo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.waygo.ui.screens.*

@Composable
fun NavGraph(navController: NavController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route  // ✅ Això ara hauria de funcionar
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.About.route) { AboutScreen(navController) }
        composable(Screen.Content1.route) { Content1Screen(navController) }
        composable(Screen.Costs.route) { CostsScreen(navController) }
        composable(Screen.FormValidation.route) { FormValidationScreen(navController) }
        composable(Screen.Help.route) { HelpScreen(navController) }
        composable(Screen.Home3.route) { HomeScreen3(navController) }
        composable(Screen.Itinerary.route) { ItineraryScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Subtask.route) { SubtaskScreen(navController) }
        composable(Screen.SubtaskSimple.route) { SubtaskScreenSimple(navController) }
        composable(Screen.TermsConditions.route) { TermsConditionsScreen(navController) }
        composable(Screen.ToDoList.route) { ToDoListScreen(navController) }
        composable(Screen.TravelCreator.route) { TravelCreatorScreen(navController) }
        composable(Screen.Travel1.route) { TravelScreen1(navController) }
        composable(Screen.Travel2.route) { TravelScreen2(navController) }
        composable(Screen.Trips.route) { TripsScreen(navController) }
        composable(Screen.Version.route) { VersionScreen(navController) }
    }
}
