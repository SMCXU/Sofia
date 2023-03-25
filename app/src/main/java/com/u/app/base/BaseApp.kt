package com.u.app.base

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/**
 * @author: Mr.U
 * @date: 2023/3/25
 * @description：
 */
@HiltAndroidApp
class BaseApp:Application() {

    companion object{
        lateinit var CONTEXT: Context
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = this
    }
}