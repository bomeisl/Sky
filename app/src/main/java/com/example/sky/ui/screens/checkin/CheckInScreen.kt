package com.example.sky.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sky.R
import com.example.sky.SkyTopAppBar
import com.example.sky.ui.navigation.SkyBottomNavBar
import com.example.sky.ui.theme.ClassicBlue
import com.example.sky.ui.theme.FadedSky
import com.example.sky.ui.theme.Sky
import com.example.sky.ui.viewModels.AppViewModelProvider
import com.example.sky.ui.viewModels.checkin.CheckinViewModel

@Composable
fun CheckInScreen(
    scaffoldState: ScaffoldState,
    onNavClick: () -> Unit
) {

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SkyTopAppBar(
                title = "Sky",
                canNavigateBack = false,
                scaffoldState = scaffoldState,
                navigateUp = {},
                onNavClick = onNavClick,
                searchItem = ""
            )
        },
        bottomBar = { SkyBottomNavBar() },
        content = {
            CheckinContent()
        }
    )
}

@Composable
fun CheckinContent() {
    if (true) {
        val alpha = remember { androidx.compose.animation.core.Animatable(0f) }
        val alpha2 = remember { Animatable(0f) }
        val alpha3 = remember { Animatable(0f) }
        val alpha4 = remember { Animatable(0f) }
        var text by remember { mutableStateOf("") }
        var text2 by remember { mutableStateOf("") }
        var text3 by remember { mutableStateOf("") }
        var animationKey by remember { mutableStateOf(false) }
        var animationKey2 by remember { mutableStateOf(false) }
        var animationKey3 by remember { mutableStateOf(false) }

        LaunchedEffect(true) {
            alpha.animateTo(1f, animationSpec = tween(3000))
        }

        if (animationKey == true) {
            LaunchedEffect(true) {
                alpha.animateTo(0f, animationSpec = tween(3000))
            }
        }

        if (animationKey == true) {
            LaunchedEffect(true) {
                alpha2.animateTo(1f, animationSpec = tween(3000))
            }
        }

        if (animationKey2 == true) {
            LaunchedEffect(true) {
                alpha2.animateTo(0f, animationSpec = tween(3000))
            }
        }

        if (animationKey2 == true) {
            LaunchedEffect(true) {
                alpha3.animateTo(1f, animationSpec = tween(3000))
            }
        }

        if (animationKey3 == true) {
            LaunchedEffect(true) {
                alpha3.animateTo(0f, animationSpec = tween(3000))
            }
        }

        if (animationKey3 == true) {
            LaunchedEffect(true) {
                alpha4.animateTo(1f, animationSpec = tween(3000))
            }
        }



        Surface(
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .alpha(alpha4.value)
                ) {

                    Text(
                        text = "Thanks! Hope you have a great day today!",
                        fontSize = 30.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center
                    )
                }
                if (!animationKey) {
                    Box(
                        modifier = Modifier
                            .alpha(alpha.value)
                            .align(Alignment.CenterHorizontally)
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth()
                                .padding(17.dp)
                        ) {

                            Text(
                                text = "How are you feeling Claire?",
                                fontSize = 30.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Center
                            )

                            Row() {

                                TextField(
                                    value = text,
                                    onValueChange = { newText -> text = newText },
                                    modifier = Modifier
                                        .padding(start = 20.dp),
                                    placeholder = { Text(text = "How are you feeling Claire?") },
                                    colors = TextFieldDefaults.textFieldColors(
                                        backgroundColor = Color.White,
                                        placeholderColor = Color.White,
                                        textColor = Color.Gray,
                                        focusedIndicatorColor = FadedSky,
                                        unfocusedIndicatorColor = Color.LightGray
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_face_3_24),
                                            "",
                                            tint = Sky
                                        )
                                    }
                                )
                                IconButton(onClick = {
                                    animationKey = true
                                },
                                    content = { Icon(Icons.Outlined.Send, "", tint = Color.Black) }
                                )
                            }

                            Spacer(modifier = Modifier.height(50.dp))

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                elevation = 20.dp
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.pexels_pixabay_531756_2),
                                    "",
                                    contentScale = ContentScale.FillBounds
                                )

                            }
                        }
                    }
                }
                if (!animationKey2) {
                    Box(
                        modifier = Modifier
                            .alpha(alpha2.value)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Text(
                                "How many hours of sleep did you get last night?",
                                color = Color.Gray,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Center
                            )
                            Row() {

                                TextField(
                                    value = text2,
                                    onValueChange = { newText -> text2 = newText },
                                    modifier = Modifier
                                        .padding(start = 20.dp),
                                    placeholder = { Text(text = "How are you feeling today Claire?") },
                                    colors = TextFieldDefaults.textFieldColors(
                                        backgroundColor = Color.White,
                                        placeholderColor = Color.White,
                                        textColor = Color.Gray,
                                        focusedIndicatorColor = FadedSky,
                                        unfocusedIndicatorColor = Color.LightGray
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_single_bed_24),
                                            "",
                                            tint = Sky
                                        )
                                    }

                                )
                                IconButton(onClick = {
                                    animationKey2 = true
                                },
                                    content = { Icon(Icons.Outlined.Send, "", tint = Color.Black) }
                                )
                            }

                            Spacer(modifier = Modifier.height(40.dp))

                            Text(
                                text = "All our dreams can come true, if we have the courage to pursue them.",
                                color = Color.Black,
                                fontSize = 30.sp,
                                fontFamily = FontFamily.Cursive,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "-Walt Disney",
                                color = ClassicBlue,
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Cursive
                            )

                            Card(elevation = 20.dp) {
                                Image(
                                    painter = painterResource(id = R.drawable.sky2),
                                    "",
                                    contentScale = ContentScale.FillWidth
                                )
                            }


                        }
                    }
                }

                if (!animationKey3) {
                    Box(
                        modifier = Modifier
                            .alpha(alpha3.value)
                            .padding(bottom = 50.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                            Text(
                                "What was your favorite part of yesterday?",
                                color = Color.Black,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Light,
                                textAlign = TextAlign.Center
                            )

                            Row() {

                                TextField(
                                    value = text3,
                                    onValueChange = { newText -> text = newText },
                                    modifier = Modifier
                                        .padding(start = 20.dp),
                                    placeholder = { Text(text = "How are you feeling today Claire?") },
                                    colors = TextFieldDefaults.textFieldColors(
                                        backgroundColor = Color.White,
                                        placeholderColor = Color.White,
                                        textColor = Color.Gray,
                                        focusedIndicatorColor = FadedSky,
                                        unfocusedIndicatorColor = Color.LightGray
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = R.drawable.baseline_tag_faces_24),
                                            "",
                                            tint = Sky
                                        )
                                    }

                                )
                                IconButton(onClick = {
                                    animationKey3 = true
                                },
                                    content = { Icon(Icons.Outlined.Send, "", tint = Color.Black) }
                                )
                            }

                            Spacer(modifier = Modifier.height(40.dp))

                            Text(
                                text = "The secret of getting ahead is just getting started",
                                color = Color.Black,
                                fontSize = 30.sp,
                                fontFamily = FontFamily.Cursive,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "—Mark Twain",
                                color = ClassicBlue,
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Cursive,
                                textAlign = TextAlign.Center
                            )
                            Card(elevation = 20.dp) {
                                Image(
                                    painter = painterResource(id = R.drawable.sky3),
                                    "",
                                    contentScale = ContentScale.FillWidth
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CheckinBanner() {

}
