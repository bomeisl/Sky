package com.example.sky.ui.screens

import android.content.Context
import android.media.MediaRecorder
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun JournalScreen() {
    var text by remember { mutableStateOf("") }
    Row() {
        TextField(
            value = text,
            leadingIcon = { Icon(Icons.Outlined.Search,"") },
            onValueChange = {newText -> text = newText},
            colors = TextFieldDefaults.textFieldColors(textColor = Color.Black, backgroundColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent),
            placeholder = {
                Text(text = "Search journal entries",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        )
    }
    VoiceRecorder()
}

@Composable
fun VoiceRecorder() {

}
