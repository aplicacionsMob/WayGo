package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AboutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "About Us")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Team Info:")
        Text(text = "Nígel Boada, Martí Farran")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Version: 1.0.0")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Summary:")
        Text(text = "WayGo is a travel application designed to facilitate trip planning and management for users. With an intuitive interface and innovative features, WayGo offers an optimized experience for adventurers.")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("home") {
                popUpTo("back") { inclusive = true }
            }
        }) {
            Text(text = "Back")
        }
    }
}