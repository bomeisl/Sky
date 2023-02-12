package com.example.sky.ui.screens

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sky.R
import com.example.sky.data.databases.schedule.ScheduleEntity
import com.example.sky.ui.AgendaItem
import com.example.sky.ui.navigation.FloatActionButton
import com.example.sky.ui.navigation.SkyBottomNavBar
import com.example.sky.ui.navigation.SkyTopAppBar
import com.example.sky.ui.theme.ClassicBlue
import com.example.sky.ui.theme.FadedSky
import com.example.sky.ui.theme.MidSky
import com.example.sky.ui.theme.Sky
import com.example.sky.viewModels.HomeViewModel
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ScheduleScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var events: State<List<ScheduleEntity>> = viewModel.uiState.collectAsState()
    var scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { SkyTopAppBar() },
        content = { ScheduleContent(displayItems = events.value) },
        bottomBar = { SkyBottomNavBar() },
        drawerContent = {
            Surface() {
                Row() {
                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "")
                }
            }

        },
        drawerGesturesEnabled = true,
        floatingActionButton = {
            Button(onClick = { viewModel.addNewAgenda() }) {
                
            }
        }
    )
}


@Composable
fun ScheduleActionButton() {
    FloatActionButton(
        onClick = { onScheduleFloatButtonClicked() },
        background = Color.White,
        icon = painterResource(id = R.drawable.icons8_journal_50),
        text = ""
    )
}

fun onScheduleFloatButtonClicked() {

}

@Composable
fun ScheduleDrawer() {

}

@Composable
fun ScheduleContent(displayItems: List<ScheduleEntity>) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Banner("Morning")
        InspirationCard()
        Row(horizontalArrangement = Arrangement.Center) {
            LazyColumn() {
                items(displayItems) { agenda ->
                    ScheduleItem(agenda)
                }
            }
        }

    }

}



@Composable
fun ScheduleItem(event: ScheduleEntity) {
    var nameText by remember { mutableStateOf(TextFieldValue("")) }
    Row(modifier = Modifier,
    horizontalArrangement = Arrangement.Center) {
        TextField(
            value = nameText,
            onValueChange = {newText -> nameText = newText},
            modifier = Modifier
                .padding(start = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                placeholderColor = Color.White,
                textColor = Color.Gray,
                focusedIndicatorColor = FadedSky,
                unfocusedIndicatorColor = Color.LightGray
            )
        )
        IconButton(
            onClick = { /*TODO*/ },
            content = {
                Image(imageVector = Icons.Outlined.Send, contentDescription = "")
            },

        )

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
                    fontSize = 35.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle(FontStyle.FONT_WEIGHT_MEDIUM),
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
    if (timeOfDay == "Morning") {
        Text(
            text = "Good $timeOfDay Claire", color = Color.Black,
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center
        )
    }
    if (timeOfDay == "Afternoon"){
        Text(
            text = "Have a Wonderful $timeOfDay Claire :)", color = Color.White,
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center
        )
    }
    if (timeOfDay == "Evening"){
        Text(
            text = "Good $timeOfDay Claire :)", color = Color.White,
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center
        )
    }
    if (timeOfDay == "Night"){
        Text(
            text = "Good $timeOfDay Claire, Sleep Well :)", color = Color.White,
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center
        )
    }
}

//@Composable
//fun TimeSelection() {
//    // Fetching local context
//    val mContext = LocalContext.current
//
//    // Declaring and initializing a calendar
//    val mCalendar = Calendar.getInstance()
//    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
//    val mMinute = mCalendar[Calendar.MINUTE]
//
//    // Value for storing time as a string
//    val mTime = remember { mutableStateOf("") }
//
//    // Creating a TimePicker dialod
//    val mTimePickerDialog = TimePickerDialog(
//        mContext,
//        {_, mHour : Int, mMinute: Int ->
//            mTime.value = "$mHour:$mMinute"
//        }, mHour, mMinute, false
//    )
//
//    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
//
//        // On button click, TimePicker is
//        // displayed, user can select a time
//        Button(onClick = { mTimePickerDialog.show() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
//            Text(text = "OK", color = Color.White)
//        }
//    }
//}