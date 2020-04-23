package com.android.trendingnews.dependencies.module

import com.android.trendingnews.data.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { NewsRepository(get(), get()) }
}