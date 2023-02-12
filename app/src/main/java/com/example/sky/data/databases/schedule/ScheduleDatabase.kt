package com.example.sky.data.databases.schedule

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import kotlin.reflect.KParameter

@Database(entities = [ScheduleEntity::class], version = 1, exportSchema = false)
abstract class ScheduleDatabase(): RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    private class ScheduleDatabaseCallback(
        private val scope: CoroutineScope
    ) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->
                scope.launch {
                    var scheduleDao = database.scheduleDao()

                    //Add sample events
                    var schedule = ScheduleEntity(
                        0,
                        "kill the president",
                        "assassinate the American president and seize power",
                        LocalDate.now(),
                        LocalTime.now(),
                        event_completed = false
                    )
                    scheduleDao.newEvent(schedule)
                    schedule = ScheduleEntity(
                        1,
                        "have some coffee",
                        "head over to Starbucks for a cup of Joe",
                        LocalDate.now(),
                        LocalTime.now(),
                        event_completed = false
                    )

                    //User event adding function
                    schedule = ScheduleEntity(/* TODO */)
                    scheduleDao.newEvent(schedule)

                }

            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ScheduleDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ScheduleDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScheduleDatabase::class.java,
                    "schedule_database"
                )
                    .addCallback(ScheduleDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
