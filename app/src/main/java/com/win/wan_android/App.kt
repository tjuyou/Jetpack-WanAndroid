package com.win.wan_android

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV
import com.win.wan_android.di.allModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.properties.Delegates

/**
 * Create by liwen on 2020-05-18
 */
class App : Application() {

    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()

        CONTEXT = applicationContext

        ARouter.init(this)
        MMKV.initialize(this)
        startKoin {

            androidContext(this@App)
            modules(allModule)
        }

    }
}