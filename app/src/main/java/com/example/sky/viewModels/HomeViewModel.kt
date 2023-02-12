package com.example.sky.viewModels

import androidx.lifecycle.ViewModel
import com.example.sky.data.databases.schedule.ScheduleEntity
import com.example.sky.ui.AgendaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(listOf<ScheduleEntity>(ScheduleEntity(0,"","","","", false)))
    val uiState: StateFlow<List<ScheduleEntity>> = _uiState.asStateFlow()


    //Business logic
    fun addNewAgenda(){

    }

    fun newText(index: Int, newText: String) {

    }
}
