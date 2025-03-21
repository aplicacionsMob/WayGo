package com.example.WayGo


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.WayGo.ui.screens.Content1
import com.example.WayGo.ui.screens.HomeScreenMenu
import com.example.WayGo.ui.screens.LoginScreen
import com.example.WayGo.ui.screens.ProfileScreen
import com.example.WayGo.ui.screens.RegisterScreen
import com.example.WayGo.ui.screens.TermConditionsScreen
import com.example.WayGo.ui.screens.AboutScreen
import com.example.WayGo.ui.screens.CostsScreen
import com.example.WayGo.ui.screens.SettingsScreen
import com.example.WayGo.ui.screens.ToDoListScreen
import com.example.WayGo.ui.screens.TravelCreatorScreen
import com.example.WayGo.ui.screens.TravelScreen1
import com.example.WayGo.ui.screens.TravelScreen2
import com.example.WayGo.ui.screens.HelpScreen


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
