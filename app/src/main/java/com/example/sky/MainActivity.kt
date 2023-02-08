package com.example.sky

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sky.ui.screens.BigPictureScheduleScreen
import com.example.sky.ui.screens.HomeScreen
import com.example.sky.ui.screens.JournalScreen
import com.example.sky.ui.screens.RecommendedActivitiesScreen
import com.example.sky.ui.theme.SkyTheme
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
                    Host()
                }
            }
        }
    }
}

@Composable
fun Host() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(navController = navController)
        }

        composable(route = "journal") {
            JournalScreen(navController = navController)
        }

        composable(route = "big_picture") {
            BigPictureScheduleScreen(navController = navController)
        }

        composable(route = "recommended") {
            RecommendedActivitiesScreen(navController = navController)
        }
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



