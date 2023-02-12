package com.example.sky.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.ui.theme.ClassicBlue
import com.example.sky.ui.theme.FadedSky
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun SkyTopAppBar() {
val scope: CoroutineScope = rememberCoroutineScope()
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
//                    scope.launch {
//                        scaffoldState.drawerState.apply {
//                            if (isClosed) open() else close()
//                        }
//                    }

                }) {
                    Icon(Icons.Filled.Menu, "")
                }
            },
            elevation = 10.dp,
            modifier = Modifier
                .background(Color.White),
            backgroundColor = ClassicBlue

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

@Composable
fun SearchBar(
) {
    var text: String by remember { mutableStateOf("") }
    
    TextField(
        value = text,
        onValueChange = {newText -> text = newText},
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = FadedSky
        ),
        placeholder = { Text(text = "Search for a scheduled event", fontSize = 20.sp)},
        trailingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "")}
    )
    
}

