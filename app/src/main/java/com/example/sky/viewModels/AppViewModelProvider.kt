package com.example.sky.viewModels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.sky.SkyApplication
import com.example.sky.viewModels.schedule.ScheduleEditViewModel
import com.example.sky.viewModels.schedule.ScheduleViewModel

object AppViewModelProvider {

    val Factory = viewModelFactory {

        //Create and instance of Schedule VM
        initializer {
            ScheduleViewModel(
                skyApplication().container.scheduleRepository
            )
        }

        //Create and instance of Schedule Edit VM
        initializer {
            ScheduleEditViewModel(
                skyApplication().container.scheduleRepository
            )
        }


    }
}

fun CreationExtras.skyApplication(): SkyApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SkyApplication)

