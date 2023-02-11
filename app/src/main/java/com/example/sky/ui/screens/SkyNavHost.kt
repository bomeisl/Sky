package com.example.sky.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SkyNavHost() {
    val navController = rememberNavController()

    NavHost(
            navController = navController,
            startDestination = "schedule"
        ) {

            composable("test") {
                Column() {
                    Text("Hello, World", color = Color.Black)
                }

            }

            composable("schedule") {
                ScheduleScreen(navController = navController)
            }

            composable("check_in") {
                CheckInScreen(navController = navController)
            }

            composable("journal") {
                JournalScreen(navController = navController)
            }

            composable("recommendations") {
                RecommendedActivitiesScreen(navController = navController)
            }

            composable("big_pic_schedule") {
                BigPictureScheduleScreen(navController = navController)
            }

        }
}