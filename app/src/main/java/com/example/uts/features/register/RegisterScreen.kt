package com.example.uts.features.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Register",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = id,
            onValueChange = { newText ->
                id = newText
            },
            label = { Text("id") },
        )
        OutlinedTextField(
            value = name,
            onValueChange = { newText ->
                name = newText
            },
            label = { Text("name") },

        )
        ElevatedButton(onClick = {
            name = ""
            id = ""
        }) {
            Text("Register")
        }
        ElevatedButton(onClick = {
            navController.popBackStack()
        }) {
            Text("Back")
        }
    }
}