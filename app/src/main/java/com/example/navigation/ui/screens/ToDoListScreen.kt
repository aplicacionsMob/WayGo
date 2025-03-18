package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ToDoListScreen(navController: NavController) {
    var newTask by remember { mutableStateOf("") }
    var tasks by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "To-Do List")
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text("New Task") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (newTask.isNotBlank()) {
                tasks = tasks + newTask
                newTask = ""
            }
        }) {
            Text(text = "Add Task")
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn { //TODO fer que es pugui borrar una tasca, tatxar-la, que tingui decoració i que no estigui al centre
            items(tasks) { task ->
                Text(text = task, modifier = Modifier.padding(8.dp))
            }
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