package com.example.sky.data

import android.content.Context
import com.example.sky.data.databases.checkin.CheckinDatabase
import com.example.sky.data.databases.schedule.ScheduleDatabase
import com.example.sky.data.repositories.checkin.CheckinRepository
import com.example.sky.data.repositories.schedule.ScheduleRepository


interface AppContainer {
    val scheduleRepository: ScheduleRepository
    val checkinRepository: CheckinRepository
}

class AppDataContainer(private val context: Context): AppContainer {
    override val scheduleRepository: ScheduleRepository by lazy {
        ScheduleRepository(ScheduleDatabase.getDatabase(context).scheduleDao())
    }
    override val checkinRepository: CheckinRepository by lazy {
        CheckinRepository(CheckinDatabase.getDatabase(context).checkinDao())
    }
}