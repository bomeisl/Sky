package com.example.sky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.sky.ui.screens.SkyNavHost
import com.example.sky.ui.theme.SkyTheme
import com.example.sky.viewModels.ScheduleViewModelFactory


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkyTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SkyApp()
                }
                }
            }
        }
    }



