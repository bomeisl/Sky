package com.example.sky.data

import android.content.Context
import com.example.sky.data.databases.schedule.ScheduleDatabase
import com.example.sky.data.repositories.ScheduleRepository


interface AppContainer {
    val scheduleRepository: ScheduleRepository
}

class AppDataContainer(private val context: Context): AppContainer {
    override val scheduleRepository: ScheduleRepository by lazy {
        ScheduleRepository(ScheduleDatabase.getDatabase(context).scheduleDao())
    }
}