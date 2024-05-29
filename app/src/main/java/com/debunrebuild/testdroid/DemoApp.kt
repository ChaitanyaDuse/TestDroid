package com.debunrebuild.testdroid

import android.app.Application
import com.debunrebuild.testdroid.di.AppModule
import com.debunrebuild.testdroid.di.ApplicationComponent
import com.debunrebuild.testdroid.di.DaggerApplicationComponent
import com.debunrebuild.testdroid.di.DemoModule
import com.debunrebuild.testdroid.di.IOModule

class DemoApp : Application() {
    companion object {
        private lateinit var appComponent: ApplicationComponent

        fun getAppComponent(): ApplicationComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        initDaggercomponent()
    }

    private fun initDaggercomponent(): ApplicationComponent {
        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule)
            .iOModule(IOModule)
            .demoModule(DemoModule).build()
        return appComponent
    }
}