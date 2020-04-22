package com.android.trendingnews.dependencies.module

import com.android.trendingnews.app.AppExecutors
import org.koin.dsl.module

val appModule = module {

    single { AppExecutors() }
}