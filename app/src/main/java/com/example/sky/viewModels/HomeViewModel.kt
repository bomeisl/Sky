package com.example.sky.viewModels

import androidx.lifecycle.ViewModel
import com.example.sky.ui.AgendaItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(listOf<AgendaItem>(AgendaItem(0,"","", "How should we start the day?")))
    val uiState: StateFlow<List<AgendaItem>> = _uiState.asStateFlow()


    //Business logic
    fun addNewAgenda(){
        _uiState.value += AgendaItem(_uiState.value.size,"","","What's next?")
    }

    fun newText(index: Int, newText: String) {

    }
}
