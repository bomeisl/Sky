package com.example.sky.ui.screens.schedule

import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.sky.ui.theme.FadedSky
import java.lang.reflect.Modifier

@Composable
fun ScheduleEditScreen() {

    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        buttons = {},
        title = {"Schedule an Event!"},
        text = { ScheduleEditContent() },
        shape = RectangleShape,
        backgroundColor = FadedSky,
        contentColor = Color.Black
    )

}

@Composable
fun ScheduleEditContent() {
    var text = remember { mutableStateOf("") }

    TextField(
        value = text.value,
        onValueChange = {},
        modifier = androidx.compose.ui.Modifier
            .padding(start = 20.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            placeholderColor = Color.White,
            textColor = Color.Gray,
            focusedIndicatorColor = FadedSky,
            unfocusedIndicatorColor = Color.LightGray
        )
    )
}