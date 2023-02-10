package com.example.sky.data

import android.content.Context
import com.example.sky.data.databases.schedule.ScheduleDatabase
import com.example.sky.data.repositories.OfflineScheduleRepository
import com.example.sky.data.repositories.ScheduleRepository
import kotlinx.coroutines.InternalCoroutinesApi


interface AppContainer {
    val scheduleRepository: ScheduleRepository
}
class AppDataContainer(private val context: Context) : AppContainer {

    @OptIn(InternalCoroutinesApi::class)
    override val scheduleRepository: ScheduleRepository by lazy {
        OfflineScheduleRepository(ScheduleDatabase.getDatabase(context).scheduleDao())
    }
}
