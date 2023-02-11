package com.example.sky

import android.app.Application
import com.example.sky.data.databases.schedule.ScheduleDatabase
import com.example.sky.data.repositories.ScheduleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.SupervisorJob

class SkyApplication(): Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    @OptIn(InternalCoroutinesApi::class)
    val database by lazy { ScheduleDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ScheduleRepository(database.scheduleDao()) }
}