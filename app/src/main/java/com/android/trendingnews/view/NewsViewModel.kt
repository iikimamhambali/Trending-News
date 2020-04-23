package com.android.trendingnews.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.android.trendingnews.base.BaseViewModel
import com.android.trendingnews.data.entity.NewsResult
import com.android.trendingnews.data.repository.NewsRepository
import com.android.trendingnews.data.response.Resource

class NewsViewModel(private val repository: NewsRepository) : BaseViewModel() {

    private val newsRequest = MutableLiveData<String>()

    val newsPopular: LiveData<Resource<NewsResult>> = Transformations
        .switchMap(newsRequest) {
            repository.getPopularNews(it)
        }

    fun getNewsPopular(key: String) {
        newsRequest.value = key
    }
}
