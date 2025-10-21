package com.example.uts.features.dashboard

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class Student(
    val id: Int,
    val name: String,
    val phone: Int,
    val address: String
)
