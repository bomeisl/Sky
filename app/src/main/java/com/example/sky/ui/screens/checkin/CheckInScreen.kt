package com.example.sky.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import com.example.sky.SkyTopAppBar
import com.example.sky.ui.navigation.SkyBottomNavBar

@Composable
fun CheckInScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SkyTopAppBar(
                title = "Sky",
                canNavigateBack = false,
                scaffoldState = scaffoldState,
                navigateUp = {}
            )
        },
        bottomBar = { SkyBottomNavBar() },
        content = {
            CheckInScreen(navController = navController)
        }
    )
}

@Composable
fun CheckInScreen() {
    
}