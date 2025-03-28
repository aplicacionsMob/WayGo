package com.example.waygo.ui.view

import com.example.waygo.R

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.profile_screen))
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("home") {
                popUpTo("home") { inclusive = true }
            }
        }) {
            Text(text = stringResource(id = R.string.back_to_home))
        }
    }
}