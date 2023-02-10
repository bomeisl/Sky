package com.example.sky.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SkyNavHost(
    modifier:Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "schedule"
    ) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable("schedule"){
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