package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HelpScreen(navController: NavController) {
    var feedback by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Help and Feedback")
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Help Topics")
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "1. How to use the app")
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "2. Account settings")
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "3. Privacy policy")
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Feedback")
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = feedback,
            onValueChange = { feedback = it },
            label = { Text("Your Feedback") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            // Handle feedback submission
        }) {
            Text(text = "Submit Feedback")
        }
        Button(onClick = {
            navController.navigate("home") {
                popUpTo("back") { inclusive = true }
            }
        }) {
            Text(text = "Back")
        }
    }
}