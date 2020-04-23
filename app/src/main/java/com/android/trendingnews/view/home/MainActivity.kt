package com.android.trendingnews.view.home

import android.content.res.Configuration
import android.os.Bundle
import androidx.lifecycle.Observer
import com.android.trendingnews.R
import com.android.trendingnews.base.BaseActivity
import com.android.trendingnews.base.BaseRecyclerView
import com.android.trendingnews.data.entity.NewsList
import com.android.trendingnews.view.NewsViewModel
import com.android.trendingnews.view.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<NewsViewModel>()

    private var resultList = mutableListOf<NewsList>()
    private val adapterHome by lazy { HomeAdapter(resultList) }

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(rvHome) {
            val orientation = resources.configuration.orientation
            initRecyclerView(
                adapterHome, when (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    true -> BaseRecyclerView.LayoutManager.VERTICAL
                    else -> BaseRecyclerView.LayoutManager.GRID
                }
            ,span = 4)
            initItemDecoration(2)
        }
    }

    private fun addData(data: List<NewsList>) {
        resultList.clear()
        resultList.addAll(data)
        adapterHome.notifyDataSetChanged()
    }

    override fun loadingData(isFromSwipe: Boolean) {
        super.loadingData(isFromSwipe)
        viewModel.getNewsPopular(getString(R.string.api_key))
    }

    override fun observeData() {
        super.observeData()
        viewModel.newsPopular.observe(this, Observer {
            parseObserveData(it, resultSuccess = { result, pagination ->
                addData(result.results)
            })
        })
    }
}
