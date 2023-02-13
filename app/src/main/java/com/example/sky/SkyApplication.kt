package com.example.sky

import android.app.Application
import com.example.sky.data.AppContainer
import com.example.sky.data.AppDataContainer

class SkyApplication : Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}