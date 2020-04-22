package com.android.trendingnews.app

import com.android.trendingnews.base.BaseApplication
import com.android.trendingnews.dependencies.libraries
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : BaseApplication() {

    override fun initApplication() {
        startKoin {
            modules(libraries)
            androidContext(this@Application)
        }
    }
}