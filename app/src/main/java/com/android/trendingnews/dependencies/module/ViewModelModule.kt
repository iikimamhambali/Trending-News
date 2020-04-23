package com.android.trendingnews.dependencies.module

import com.android.trendingnews.view.NewsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { NewsViewModel(get()) }
}