package com.example.sky.ui.screens

import android.annotation.SuppressLint
import android.graphics.fonts.Font
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.AppBarDefaults.ContentPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sky.R
import com.example.sky.SearchBar
import com.example.sky.TimeSelection
import com.example.sky.ui.AgendaItem
import com.example.sky.viewModels.HomeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val homeUiState by homeViewModel.uiState.collectAsState()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        scaffoldState = scaffoldState,

        topBar = {
            Column() {
                TopAppBar(

                    title = {
                        Text(text = "Sky",
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 40.sp)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                scaffoldState.drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }

                        } ) {
                            Icon(Icons.Filled.Menu, "")
                        }
                    },
                    elevation = 10.dp,
                    modifier = Modifier
                        .background(Color.White)
                )
                SearchBar()
            }

        },

        drawerGesturesEnabled = true,

        content = {
            Column {
                it
                Banner("Morning")
                InspirationCard()
                LazyColumn {
                    items(homeUiState) { agenda ->
                        AgendaItem(agenda)
                    }
                }
            }
        },

        floatingActionButtonPosition = FabPosition.End,

        floatingActionButton = {
            Row() {
                FloatingActionButton(
                    onClick = {
                        homeViewModel.addNewAgenda()
                    },
                    backgroundColor = Color.LightGray,
                    content = { Icon(Icons.Outlined.Add,"") }
                )
            }

        },

        bottomBar = {
            BottomNavigation() {
                BottomNavigationItem(icon = { Icon(Icons.Outlined.ArrowBack,"") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(icon = { Icon(Icons.Outlined.Home,"") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                BottomNavigationItem(icon = { Icon(Icons.Outlined.Home,"") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
            }
        },

        drawerBackgroundColor = Color.White,
        drawerContentColor = Color.Black,
        drawerContent = {

            Row(modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Where to?", modifier = Modifier.padding(16.dp), fontFamily = FontFamily.Cursive, fontSize = 30.sp)
                
            }

            Divider()
            Row(modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.baseline_menu_book_24), "")
                Text(text = "Claire's Journal", modifier = Modifier.padding(16.dp))
            }

            Divider()
            Row(modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.baseline_calendar_month_24), "")
                Text(text = "Schedule Planner", modifier = Modifier.padding(16.dp))
            }

            Divider()
            Row(modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.baseline_downhill_skiing_24), "")
                Text(text = "Fun Stuff To Do", modifier = Modifier.padding(16.dp))
            }



        },

    )
}

@Composable
fun Drawer() {
    Box(modifier = Modifier
        .fillMaxSize()) {
        TopMenuItem(iconId = R.drawable.evening_sky, item = "Claire's Journal")
    }



}

@Composable
fun TopMenuItem(iconId: Int, item: String) {
    Card() {
        Row() {
            Image(painter = painterResource(id = iconId),"")
            Text(text = item)
        }
    }
}

@Composable
fun AgendaItem(
    agenda: AgendaItem,
    homeViewModel: HomeViewModel = viewModel()
) {
    var text by remember { mutableStateOf("") }
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        elevation = 10.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = { }) {
                Row {
                    TextField(
                        value = text,
                        onValueChange = { newText -> text = newText },
                        colors = TextFieldDefaults.textFieldColors(textColor = Color.Black, backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
                        placeholder = {
                            Text(text = agenda.placeholder,
                                fontWeight = FontWeight.Black,
                                fontSize = 23.sp,
                                fontFamily = FontFamily.Cursive
                            ) }
                    )
                    TimeSelection()

                }
            }

        }

    }

}

@Composable
fun InspirationCard() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        elevation = 0.dp,
        backgroundColor = Color.White,
    ) {
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(15.dp)
        ) {
            Box() {
                Text(text = "What're We Doing Today?", color = Color.DarkGray,
                    fontSize = 30.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle(FontStyle.FONT_WEIGHT_EXTRA_LIGHT),
                    fontFamily = FontFamily.Cursive)

            }
        }

    }
}

@Composable
fun Banner(timeOfDay: String) {
    Box( contentAlignment = Alignment.Center) {
        BannerImage(timeOfDay)
        BannerText(timeOfDay)
    }
}

@Composable
fun BannerImage(timeOfDay: String) {
    if (timeOfDay == "Morning") {

        Image(painter = painterResource(id = R.drawable.morning_sky),
            contentDescription = "morning",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )


    }
    if (timeOfDay == "Afternoon") {

        Image(painter = painterResource(id = R.drawable.afternoon_sky),
            contentDescription = "morning",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

    }
    if (timeOfDay == "Evening") {

        Image(painter = painterResource(id = R.drawable.evening_sky),
            contentDescription = "morning",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

    }
    if (timeOfDay == "Night") {

        Image(painter = painterResource(id = R.drawable.night),
            contentDescription = "morning",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

    }
}

@Composable
fun BannerText(timeOfDay: String) {
    Text(
        text = "Good $timeOfDay Claire", color = Color.White,
        fontSize = 50.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Black
    )
}
