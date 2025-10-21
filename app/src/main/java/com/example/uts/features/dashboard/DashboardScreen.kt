package com.example.uts.features.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.uts.features.dashboard.Student

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val students = remember {
        mutableStateListOf(
            Student(id = 10, name = "halo"),
            Student(id = 10, name = "halo"),
            Student(id = 10, name = "halo"),
            Student(id = 10, name = "halo"),
        )
    }
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Student Roster",
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(bottom = 8.dp, top = 30.dp)
                )
                IconButton(onClick = {
                    navController.navigate("register")
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "add student"
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
            ) {
                items(students) { student ->
                    StudentCard(id = student.id, name = student.name)
                }
            }
        }
    }

}

@Composable
fun StudentCard(
    id: Int,
    name: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(vertical = 4.dp, horizontal = 10.dp),
        color = Color.LightGray
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("$id")
                Text(name)
            }
        }
    }
}

@Composable
@Preview
fun PreviewStudentCard() {
    StudentCard(
        id = 10,
        name = "adan",
    )
}