package com.example.sky.ui.viewModels.checkin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sky.data.repositories.checkin.CheckinRepository


class CheckinViewModelFactory(
    private val checkinDao: CheckinRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CheckinViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CheckinViewModel(checkinDao) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}