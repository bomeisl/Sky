package com.example.sky.ui.viewModels.checkin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sky.data.databases.checkin.Checkin
import com.example.sky.data.repositories.checkin.CheckinRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDate

data class CheckinUiList(
    val checkinList: MutableList<Checkin>
)

class CheckinViewModel(private val checkinRepository: CheckinRepository): ViewModel() {
    val today: String = LocalDate.now().toString()

    val checkinToday: StateFlow<Checkin?> =
        checkinRepository.getCheckinDateStream(today).stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(CheckinViewModel.TIMEOUT_MILLIS),
            initialValue = null
        )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val checkinList: StateFlow<CheckinUiList> =
        checkinRepository.getAllCheckinsStream().map { CheckinUiList(it as MutableList<Checkin>) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(CheckinViewModel.TIMEOUT_MILLIS),
                initialValue = CheckinUiList(
                    mutableListOf(),
                    )
                )

}