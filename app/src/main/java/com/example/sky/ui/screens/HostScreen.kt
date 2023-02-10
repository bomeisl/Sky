package com.example.sky.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sky.R
import com.example.sky.viewModels.HomeViewModel
import kotlinx.coroutines.launch


//@Composable
//fun HostScreen(
//    homeViewModel: HomeViewModel = viewModel(),
//    content: @Composable() () -> Unit
//) {
//    val navController = rememberNavController()
//    val homeUiState by homeViewModel.uiState.collectAsState()
//    val scaffoldState = rememberScaffoldState()
//    val scope = rememberCoroutineScope()
//    Scaffold(
//        modifier = Modifier.statusBarsPadding(),
//        scaffoldState = scaffoldState,
//
//        topBar = {
//
//
//        },
//
//        drawerGesturesEnabled = true,
//
//        content = {
//            content
//        },
//
//        floatingActionButtonPosition = FabPosition.End,
//
//        floatingActionButton = {
//            Row() {
//                FloatingActionButton(
//                    onClick = {
//                        homeViewModel.addNewAgenda()
//                    },
//                    backgroundColor = Color.LightGray,
//                    content = { Icon(Icons.Outlined.Add,"") }
//                )
//            }
//
//        },
//
//        bottomBar = {
//            BottomNavigation() {
//                BottomNavigationItem(icon = { Icon(Icons.Outlined.ArrowBack,"") },
//                    selected = false,
//                    onClick = { /*TODO*/ }
//                )
//                BottomNavigationItem(icon = { Icon(Icons.Outlined.Home,"") },
//                    selected = false,
//                    onClick = { /*TODO*/ }
//                )
//                BottomNavigationItem(icon = { Icon(Icons.Outlined.Home,"") },
//                    selected = false,
//                    onClick = { /*TODO*/ }
//                )
//            }
//        },
//
//        drawerBackgroundColor = Color.White,
//        drawerContentColor = Color.Black,
//        drawerContent = {
//
//
//
//
//        },
//
//        )
//}