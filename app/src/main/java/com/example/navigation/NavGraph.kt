package com.example.navigation


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navigation.ui.screens.Content1
import com.example.navigation.ui.screens.HomeScreenMenu
import com.example.navigation.ui.screens.LoginScreen
import com.example.navigation.ui.screens.ProfileScreen
import com.example.navigation.ui.screens.RegisterScreen
import com.example.navigation.ui.screens.TermConditionsScreen
import com.example.navigation.ui.screens.AboutScreen
import com.example.navigation.ui.screens.CostsScreen
import com.example.navigation.ui.screens.SettingsScreen
import com.example.navigation.ui.screens.ToDoListScreen
import com.example.navigation.ui.screens.TravelCreatorScreen
import com.example.navigation.ui.screens.TravelScreen1
import com.example.navigation.ui.screens.TravelScreen2
import com.example.navigation.ui.screens.HelpScreen


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
