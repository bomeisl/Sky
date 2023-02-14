package com.example.sky

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.ui.theme.ClassicBlue
import com.example.sky.ui.theme.FadedSky
import kotlinx.coroutines.launch


@Composable
fun SkyTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {},
    scaffoldState: ScaffoldState,
    onNavClick: () -> Unit,
    searchItem: String
) {
    val scope = rememberCoroutineScope()

    if (canNavigateBack) {
                Column {
                    TopAppBar(
                        title = {
                            Text(
                                text = title,
                                fontWeight = FontWeight.Black,
                                fontFamily = FontFamily.Cursive,
                                fontSize = 40.sp
                            )
                        },
                        modifier = modifier,
                        elevation = 10.dp,
                        contentColor = Color.White,
                        backgroundColor = ClassicBlue,
                        navigationIcon = {
                            Row() {

                                IconButton(
                                    onClick = {
                                        scope.launch {
                                            scaffoldState.drawerState.apply {
                                                if (isClosed) open() else close()
                                            }
                                        }
                                    },
                                    modifier = Modifier,
                                    content = { Icon(Icons.Filled.Menu, "") }
                                )

                                IconButton(
                                    onClick = navigateUp,
                                    modifier = Modifier,
                                    content = {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBack,
                                            contentDescription = ""
                                        )
                                    }
                                )
                            }
                        }
                    )
                    SearchBar(searchItem)
                }
            } else {
                Column() {

                    TopAppBar(
                        title = {
                            Text(
                                text = title,
                                fontWeight = FontWeight.Black,
                                fontFamily = FontFamily.Cursive,
                                fontSize = 40.sp
                            )
                        },
                        modifier = modifier,
                        elevation = 10.dp,
                        contentColor = Color.White,
                        backgroundColor = ClassicBlue,
                        navigationIcon = {
                            Row() {

                                IconButton(
                                    onClick = onNavClick,
                                    modifier = Modifier,
                                    content = { Icon(Icons.Filled.Menu, "") }
                                )
                            }
                        }
                    )
                    SearchBar(searchItem)
                }
        }

}






@Composable
fun SkyBottomNavBar(
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit = {}
) {
    if (canNavigateBack) {
        BottomAppBar(
            modifier = modifier,

            ) {
            NavigationRail() {
                NavigationRailItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {Icons.Outlined.ArrowBack}
                )
                NavigationRailItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {Icons.Outlined.Home}
                )
                NavigationRailItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {Icons.Outlined.ArrowForward}
                )
            }
        }
    }
}


@Composable
fun SearchBar(
    searchItem: String
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
        placeholder = { Text(text = "Search for $searchItem", fontSize = 20.sp)},
        trailingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "")}
    )

}