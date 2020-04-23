package com.android.trendingnews.data.network

import androidx.lifecycle.LiveData
import com.android.trendingnews.data.entity.NewsResult
import com.android.trendingnews.data.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("mostpopular/v2/viewed/1.json")
    fun getPopularNews(@Query("api-key") apiKey: String): LiveData<ApiResponse<NewsResult>>

}