package com.example.sky.ui.screens

import android.annotation.SuppressLint
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Check
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sky.R
import com.example.sky.SkyTopAppBar
import com.example.sky.data.databases.schedule.Event
import com.example.sky.data.databases.schedule.EventPriority
import com.example.sky.ui.navigation.SkyBottomNavBar
import com.example.sky.ui.theme.*
import com.example.sky.viewModels.AppViewModelProvider
import com.example.sky.viewModels.schedule.EventList
import com.example.sky.viewModels.schedule.ScheduleEditViewModel
import com.example.sky.viewModels.schedule.ScheduleViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel = viewModel(factory = AppViewModelProvider.Factory),
    scaffoldState: ScaffoldState,
    onNavClick: () -> Unit
) {
    val uiState = viewModel.scheduleUiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { SkyTopAppBar("Sky",false, Modifier , {}, scaffoldState, onNavClick, "a scheduled event") },
        content = { ScheduleContent(uiState, scaffoldState) },
        bottomBar = { SkyBottomNavBar() }
    )
}

@Composable
fun DrawerContent(
    onCheckinNav: () -> Unit,
    onJournalNav: () -> Unit,
    onScheduleNav: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Surface(
            elevation = 15.dp
        ) {
            Column() {

                Row(
                    Modifier
                        .background(ClassicBlue)
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Sky",
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center
                    )


                }


                Row(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(0.dp)
                        .background(FadedSky),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Where to?",
                        color = Color.DarkGray,
                        fontSize = 45.sp,
                        fontFamily = FontFamily.Cursive
                    )

                }
            }
        }
    }
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Divider(color = Sky, thickness = 1.dp)
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Home,
                contentDescription = "",
                tint = Color.Gray
            )
            Text(
                text = "Home",
                color = Color.Gray,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        Divider(color = Sky, thickness = 1.dp)

        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icons8_journal_50),
                contentDescription = "",
                tint = Color.Gray
            )
            Text(text = "Journal", color = Color.Gray, fontSize = 20.sp)
        }
        Divider(color = Sky, thickness = 1.dp)

        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = onCheckinNav) {

                Icon(
                    imageVector = Icons.Outlined.Check,
                    contentDescription = "",
                    tint = Color.Gray
                )
                Text(text = "Check In", color = Color.Gray, fontSize = 20.sp)
            }

        }
        Divider(color = Sky, thickness = 1.dp)
    }
}





    @Composable
    fun ScheduleContent(uiState: State<EventList>, scaffoldState: ScaffoldState) {
        var eventList = uiState.value.eventList

        Column(
            modifier = Modifier
                .padding(bottom = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Banner()
            InspirationCard()
            Row(horizontalArrangement = Arrangement.Center) {
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item { EventBlank(eventList.size + 1, scaffoldState) }

                    items(eventList.size) { item ->
                        ScheduleItem(event = eventList[item], item, scaffoldState)

                    }
                }
            }

        }

    }

    @Composable
    fun EventBlank(
        id: Int,
        scaffoldState: ScaffoldState,
        scheduleEditViewModel: ScheduleEditViewModel = viewModel(factory = AppViewModelProvider.Factory)
    ) {
        val scope = rememberCoroutineScope()
        var text by remember { mutableStateOf("") }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(horizontalArrangement = Arrangement.Center) {

                TextField(
                    value = text,
                    onValueChange = { newText -> text = newText },
                    modifier = Modifier
                        .padding(start = 20.dp),
                    placeholder = { Text(text = "Ex: 'Have Breakfast'", fontSize = 20.sp) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        placeholderColor = Color.Black,
                        textColor = Color.Gray,
                        focusedIndicatorColor = FadedSky,
                        unfocusedIndicatorColor = Color.LightGray,
                    ),
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.baseline_add_task_24),
                            "",
                            tint = Sky
                        )
                    },
                )
                IconButton(
                    onClick = {
                        scope.launch {
                            scheduleEditViewModel.addEvent(
                                Event(
                                    id = id,
                                    event_name = text,
                                    event_description = text,
                                    event_date = "",
                                    event_time = "",
                                    event_priority = EventPriority.ONE,
                                    event_completed = false
                                )
                            )
                            text = ""
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = "New event scheduled!"
                            )

                        }

                    },
                    content = {
                        Icon(
                            imageVector = Icons.Outlined.Send,
                            contentDescription = "",
                            tint = Sky
                        )
                    }
                )
            }
        }
    }


    @Composable
    fun ScheduleItem(
        event: Event,
        id: Int,
        scaffoldState: ScaffoldState,
        viewModel: ScheduleEditViewModel = viewModel(factory = AppViewModelProvider.Factory),
    ) {
        var nameText: String by remember { mutableStateOf("") }
        val scope = rememberCoroutineScope()
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = nameText,
                onValueChange = { newText -> nameText = newText },
                modifier = Modifier
                    .padding(start = 20.dp),
                placeholder = { Text(text = event.event_name, fontSize = 20.sp) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    placeholderColor = Color.Black,
                    textColor = Color.Gray,
                    focusedIndicatorColor = FadedSky,
                    unfocusedIndicatorColor = Color.LightGray
                ),
                leadingIcon = {

                    if (!event.event_completed) {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    viewModel.updateEvent(
                                        event = Event(
                                            event.id,
                                            event_name = event.event_name,
                                            event_description = event.event_description,
                                            event_date = event.event_date,
                                            event_time = event.event_time,
                                            event_completed = !event.event_completed,
                                            event_priority = event.event_priority
                                        )
                                    )
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        message = "Event Completed! (${event.event_name})"
                                    )
                                }
                            },
                            content = {
                                Icon(
                                    painterResource(id = R.drawable.baseline_task_alt_24),
                                    "",
                                    tint = Color.Gray
                                )
                            }
                        )
                    }
                    if (event.event_completed) {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    viewModel.updateEvent(
                                        event = Event(
                                            event.id,
                                            event_name = event.event_name,
                                            event_description = event.event_description,
                                            event_date = event.event_date,
                                            event_time = event.event_time,
                                            event_completed = !event.event_completed,
                                            event_priority = event.event_priority
                                        )
                                    )
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        message = "Event Incomplete (${event.event_name})"
                                    )
                                }
                            },
                            content = {
                                Icon(
                                    painterResource(id = R.drawable.baseline_task_alt_24),
                                    "",
                                    tint = DarkGreen
                                )
                            }
                        )
                    }
                },

                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "",
                        tint = MidSky
                    )
                }
            )

            IconButton(
                onClick = {
                    scope.launch {
                        viewModel.updateEvent(
                            Event(
                                id = id + 1,
                                event_name = nameText,
                                event_description = nameText,
                                event_date = "",
                                event_time = "",
                                event_priority = EventPriority.ONE,
                                event_completed = false
                            )
                        )
                        scaffoldState.snackbarHostState.showSnackbar(message = "Event updated (${event.event_name})")
                    }

                },
                content = {
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = "",
                        tint = Sky
                    )
                },

                )
            IconButton(
                onClick = {
                    scope.launch {
                        viewModel.deleteEvent(event)
                        scaffoldState.snackbarHostState.showSnackbar(message = "Event removed")
                    }
                },
                content = {
                    Icon(
                        painterResource(id = R.drawable.baseline_delete_24),
                        "",
                        tint = Color.Red
                    )
                },
            )
        }
    }

    @Composable
    fun Event(
        event: Event,
    ) {
        var nameText: String by remember { mutableStateOf("") }
        val scope = rememberCoroutineScope()
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = nameText,
                onValueChange = { newText -> nameText = newText },
                modifier = Modifier
                    .padding(start = 20.dp),
                placeholder = { Text(text = event.event_name) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    placeholderColor = Color.White,
                    textColor = Color.Gray,
                    focusedIndicatorColor = FadedSky,
                    unfocusedIndicatorColor = Color.LightGray
                )
            )
            IconButton(
                onClick = {
                },
                content = {
                    Image(imageVector = Icons.Outlined.Send, contentDescription = "")
                },

                )

        }
    }

    @Composable
    fun InspirationCard() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            elevation = 0.dp,
            backgroundColor = Color.White,
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Box() {
                    Text(
                        text = "What're We Doing Today?", color = Color.DarkGray,
                        fontSize = 35.sp,
                        fontStyle = androidx.compose.ui.text.font.FontStyle(FontStyle.FONT_WEIGHT_MEDIUM),
                        fontFamily = FontFamily.Cursive
                    )

                }
            }

        }
    }

    @Composable
    fun Banner() {
        //val time: Int by remember { mutableStateOf(LocalTime.now().hour)}
        val time = 17
        Box(contentAlignment = Alignment.Center) {
            BannerImage(time)
            BannerText(time)
        }
    }

    @Composable
    fun BannerImage(time: Int) {

        if ((time >= 5) and (time < 12)) {

            Image(
                painter = painterResource(id = R.drawable.morning_sky),
                contentDescription = "morning",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )


        }
        if ((time >= 12) and (time < 17)) {

            Image(
                painter = painterResource(id = R.drawable.afternoon_sky),
                contentDescription = "morning",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

        }
        if ((time >= 17) and (time < 20)) {

            Image(
                painter = painterResource(id = R.drawable.evening_sky),
                contentDescription = "morning",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

        }
        if ((time >= 20) or (time < 5)) {

            Image(
                painter = painterResource(id = R.drawable.night),
                contentDescription = "morning",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

        }
    }

    @Composable
    fun BannerText(time: Int) {
        if ( (time >= 5) and (time < 12) ) {
            Text(
                text = "Good Morning Claire", color = Color.Black,
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
        if ((time >= 12) and (time < 17)) {
            Text(
                text = "Have a Wonderful Afternoon Claire :)", color = Color.White,
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
        if ((time >= 17 ) and (time < 20)) {
            Text(
                text = "Good Evening Claire :)", color = Color.White,
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
        if ((time < 5) or (time >= 20)) {
            Text(
                text = "Good Night Claire, Sleep Well :)", color = Color.White,
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