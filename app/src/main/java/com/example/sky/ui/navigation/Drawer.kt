package com.example.sky.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sky.R

@Composable
fun Drawer(navController: NavController) {
    Row(modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(  "Where to?", modifier = Modifier.padding(16.dp), fontFamily = FontFamily.Cursive, fontSize = 30.sp)

    }

    Divider()
    Row(modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.baseline_menu_book_24), "")
        TextButton({ navController.navigate("journal") }) {
            Text(text = "Claire's Journal", modifier = Modifier.padding(16.dp))
        }
    }

    Divider()
    Row(modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.baseline_calendar_month_24), "")
        TextButton({ navController.navigate("big_picture") }) {
            Text(text = "Schedule View", modifier = Modifier.padding(16.dp))
        }
    }

    Divider()
    Row(modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.baseline_downhill_skiing_24), "")
        TextButton({ navController.navigate("recommended") }) {
            Text(text = "Fun Suggestions", modifier = Modifier.padding(16.dp))
        }
    }

}