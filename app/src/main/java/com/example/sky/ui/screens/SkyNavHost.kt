package com.example.sky.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sky.ui.screens.drawer.DrawerScreen
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SkyNavHost(
    scope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {

        NavHost(
            navController = navController,
            startDestination = "drawer"
        ) {

            composable("drawer") {
                DrawerScreen(
                    onCheckinNav = { navController.navigate("check_in") },
                    onJournalNav = { navController.navigate("journal") },
                    onScheduleNav = { navController.navigate("schedule") },

                    )
            }

            composable("schedule") {
                ScheduleScreen(
                    scaffoldState = scaffoldState,
                    onNavClick = {
                        navController.navigate("drawer")
                    }
                )


            }

            composable("check_in") {
                CheckInScreen(
                    scaffoldState = scaffoldState,
                    onNavClick = {
                        navController.navigate("drawer")
                    }
                )
            }

            composable("journal") {
                JournalScreen()
            }


        }
    }
