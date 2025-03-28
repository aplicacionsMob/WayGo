package com.example.waygo.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.waygo.R

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
        Text(text = stringResource(id = R.string.todo_list))
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = newTask,
            onValueChange = { newTask = it },
            label = { Text(stringResource(id = R.string.new_task)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (newTask.isNotBlank()) {
                tasks = tasks + newTask
                newTask = ""
            }
        }) {
            Text(text = stringResource(id = R.string.add_task))
        }
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(tasks) { task ->
                Text(text = task, modifier = Modifier.padding(8.dp))
            }
        }
        Button(onClick = {
            navController.navigate("home") {
                popUpTo("back") { inclusive = true }
            }
        }) {
            Text(text = stringResource(id = R.string.back))
        }
    }
}