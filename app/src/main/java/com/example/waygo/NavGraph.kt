package com.example.waygo


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.waygo.ui.view.Content1
import com.example.waygo.ui.view.HomeScreenMenu
import com.example.waygo.ui.view.LoginScreen
import com.example.waygo.ui.view.ProfileScreen
import com.example.waygo.ui.view.RegisterScreen
import com.example.waygo.ui.view.TermConditionsScreen
import com.example.waygo.ui.view.AboutScreen
import com.example.waygo.ui.view.CostsScreen
import com.example.waygo.ui.view.SettingsScreen
import com.example.waygo.ui.view.ToDoListScreen
import com.example.waygo.ui.view.TravelCreatorScreen
import com.example.waygo.ui.view.TravelScreen1
import com.example.waygo.ui.view.TravelScreen2
import com.example.waygo.ui.view.HelpScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreenMenu(navController) { innerPadding ->
            Content1(navController, innerPadding)
        }}
        composable("profile") { ProfileScreen(navController) }
        composable("profileMenu") { ProfileScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("terms") { TermConditionsScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("creator") { TravelCreatorScreen(navController) }
        composable("cost") { CostsScreen(navController) }
        composable("todo") { ToDoListScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("travel1") { TravelScreen1(navController) }
        composable("travel2") { TravelScreen2(navController) }
        composable("help") { HelpScreen(navController) }
    }
}
