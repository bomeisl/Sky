package com.example.sky.viewModels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.sky.SkyApplication

object AppViewModelProvider {

    val Factory = viewModelFactory {
        initializer {
            ScheduleViewModel(
                skyApplication().container.scheduleRepository
            )
        }

    }
}

fun CreationExtras.skyApplication(): SkyApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SkyApplication)

