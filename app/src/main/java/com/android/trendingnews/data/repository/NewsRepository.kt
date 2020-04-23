package com.android.trendingnews.data.repository

import androidx.lifecycle.LiveData
import com.android.trendingnews.app.AppExecutors
import com.android.trendingnews.data.entity.NewsResult
import com.android.trendingnews.data.network.NewsService
import com.android.trendingnews.data.response.ApiResponse
import com.android.trendingnews.data.response.Resource

class NewsRepository(
    private val appExecutors: AppExecutors,
    private val service: NewsService
) {

    fun getPopularNews(apiKey: String): LiveData<Resource<NewsResult>> {
        return object : RepostioryLiveData<NewsResult>(appExecutors) {
            override fun loadFromNetwork(): LiveData<ApiResponse<NewsResult>> =
                service.getPopularNews(apiKey)
        }.asLiveData()
    }
}