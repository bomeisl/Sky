package com.example.sky.ui.screens.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.example.sky.R
import com.example.sky.ui.theme.ClassicBlue

@Composable
fun DrawerScreen(
    onCheckinNav: () -> Unit,
    onJournalNav: () -> Unit,
    onScheduleNav: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

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


            }
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.sky_logo_final),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    alpha = 1F
                )
                Column(
                    Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom
                ) {


                    DrawerItem(
                        icon_id = R.drawable.icons8_journal_50,
                        text = "Journal",
                        onJournalNav
                    )

                    Divider(color = Color.White, thickness = 1.dp)

                    DrawerItem(
                        icon_id = R.drawable.baseline_add_task_24,
                        text = "Check In",
                        onCheckinNav
                    )

                    Divider(color = Color.White, thickness = 1.dp)

                    DrawerItem(
                        icon_id = R.drawable.baseline_calendar_month_24,
                        text = "To Do",
                        onScheduleNav
                    )

                    Divider(color = Color.White, thickness = 1.dp)


                }


            }
        }
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
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = onItemClick ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(modifier = Modifier
                    .padding(10.dp),
                    painter = painterResource(id = icon_id),
                    contentDescription = "",
                    tint = Color.White
                )
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}