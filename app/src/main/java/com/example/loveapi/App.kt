package com.example.loveapi

import android.app.Application
import com.example.loveapi.utils.PreferenceHelper

class App: Application() {

    override fun onCreate(){
        super.onCreate()
        val sharedPreferences = PreferenceHelper
        sharedPreferences.unit(this)
    }
}