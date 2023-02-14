package com.example.sky.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.R
import com.example.sky.SkyTopAppBar
import com.example.sky.ui.navigation.SkyBottomNavBar
import com.example.sky.ui.theme.FadedSky
import com.example.sky.ui.theme.Sky

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
                searchItem = "check ins"
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
    val alpha = remember { androidx.compose.animation.core.Animatable(0f) }
    var text by remember { mutableStateOf("") }
    var animationKey by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        alpha.animateTo(1f, animationSpec = tween(3000))
    }

    if (animationKey == true) {
        LaunchedEffect(true) {
            alpha.animateTo(0f, animationSpec = tween(3000))
        }
    }

    Surface(
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                .alpha(alpha.value)
            ) {
                Column() {

                    Text(text = "How are you feeling today?", fontSize = 30.sp, color = Color.Black)

                    Row() {

                        TextField(
                            value = text,
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
                            )
                        )
                        IconButton(onClick = { animationKey = true },
                            content = { Icons.Outlined.Send }

                        )
                    }
                }
            }

            Box(
                modifier = Modifier
            ) {

            }

        }



    }

}
