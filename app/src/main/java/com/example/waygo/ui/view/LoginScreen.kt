package com.example.waygo.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.waygo.R

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.login_screen))
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(id = R.string.user)) }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(id = R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            // Navigate to Home and remove Login from the back stack
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
        }) {
            Text(text = stringResource(id = R.string.login))
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Afegeix un petit marge
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd), // Alinea el contingut a baix a la dreta
            verticalAlignment = Alignment.CenterVertically // Centra verticalment el text i el botó
        ) {
            Text(text = stringResource(id = R.string.dont_have_account))
            Spacer(modifier = Modifier.width(8.dp)) // Espai entre el text i el botó
            Button(onClick = { navController.navigate("register") }) {
                Text(text = stringResource(id = R.string.register))
            }
        }
    }
}