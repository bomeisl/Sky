package com.example.sky.ui.navigation

import android.app.TimePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import java.util.*


@Composable
fun UpperAppBar() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Column() {
        TopAppBar(

            title = {
                Text(
                    text = "Sky",
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 40.sp
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }

                }) {
                    Icon(Icons.Filled.Menu, "")
                }
            },
            elevation = 10.dp,
            modifier = Modifier
                .background(Color.White)
        )
        SearchBar()
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

