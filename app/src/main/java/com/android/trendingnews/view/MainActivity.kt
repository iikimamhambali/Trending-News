package com.android.trendingnews.view

import androidx.lifecycle.Observer
import com.android.trendingnews.R
import com.android.trendingnews.base.BaseActivity
import org.jetbrains.anko.toast
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<NewsViewModel>()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun loadingData(isFromSwipe: Boolean) {
        super.loadingData(isFromSwipe)
        viewModel.getNewsPopular(getString(R.string.api_key))
    }

    override fun observeData() {
        super.observeData()
        viewModel.newsPopular.observe(this, Observer {
            parseObserveData(it, resultSuccess = { result, pagination ->
                toast("Success")
            })
        })
    }
}
