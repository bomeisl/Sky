package com.example.sky.ui.viewModels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.sky.SkyApplication
import com.example.sky.ui.viewModels.checkin.CheckinViewModel
import com.example.sky.ui.viewModels.schedule.ScheduleEditViewModel
import com.example.sky.ui.viewModels.schedule.ScheduleViewModel

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

        //Create an instance of Checkin VM
        initializer {
            CheckinViewModel(
                skyApplication().container.checkinRepository
            )
        }


    }
}

fun CreationExtras.skyApplication(): SkyApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SkyApplication)

