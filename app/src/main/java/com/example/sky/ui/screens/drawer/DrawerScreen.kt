package com.example.sky.ui.screens.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sky.R
import com.example.sky.ui.theme.ClassicBlue
import com.example.sky.ui.theme.FadedSky
import com.example.sky.ui.theme.Sky

@Composable
fun DrawerScreen(
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

        DrawerItem(icon_id = R.drawable.icons8_journal_50, text = "Journal", onJournalNav)

        Divider(color = Sky, thickness = 1.dp)

        DrawerItem(icon_id = R.drawable.baseline_add_task_24, text = "Check In", onCheckinNav)

        Divider(color = Sky, thickness = 1.dp)

        DrawerItem(icon_id = R.drawable.baseline_calendar_month_24, text = "To Do", onScheduleNav)

        Divider(color = Sky, thickness = 1.dp)
        }
    }


@Composable
fun DrawerItem(
    icon_id: Int,
    text: String,
    onItemClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = onItemClick ) {
            Icon(painter = painterResource(id = icon_id), contentDescription = "")
            Text(
                text = text,
                color = Color.Gray,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}