package com.example.sky

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.graphics.fonts.FontStyle.FONT_WEIGHT_EXTRA_LIGHT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sky.ui.AgendaItem
import com.example.sky.ui.theme.SkyTheme
import com.example.sky.viewModels.HomeViewModel
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    HomeScreen(navController)
                }
            }
        }
    }
}

@Composable
fun Splash(navController: NavHostController) {
    Box(contentAlignment = Alignment.Center) {

        Image(painter = painterResource(id = R.drawable.sky_logo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()

        )

    }
}

@Composable
fun SearchBar() {
    var text: String by remember { mutableStateOf("") }
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()

    )
    {
        TextField(
            value = text,
            leadingIcon = { Icon(Icons.Outlined.Search,"") },
            onValueChange = {newText -> text = newText},
            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black, backgroundColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
            placeholder = {
                Text(text = "Search scheduled activities",
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Black,
                    fontSize = 23.sp
            )},
            modifier = Modifier
                .fillMaxWidth()
        )
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val homeUiState by homeViewModel.uiState.collectAsState()
    Scaffold(
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

        content = {
            Column {
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
        }

    )
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
fun TimeSelection() {
    // Fetching local context
    val mContext = LocalContext.current

    // Declaring and initializing a calendar
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    // Value for storing time as a string
    val mTime = remember { mutableStateOf("") }

    // Creating a TimePicker dialod
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        {_, mHour : Int, mMinute: Int ->
            mTime.value = "$mHour:$mMinute"
        }, mHour, mMinute, false
    )

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        // On button click, TimePicker is
        // displayed, user can select a time
        Button(onClick = { mTimePickerDialog.show() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
            Text(text = "OK", color = Color.White)
        }
    }
}

fun onSelected() {
    /*TODO*/
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
                    fontStyle = FontStyle(FONT_WEIGHT_EXTRA_LIGHT),
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


