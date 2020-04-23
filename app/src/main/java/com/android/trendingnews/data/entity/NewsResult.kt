package com.android.trendingnews.data.entity

import com.google.gson.annotations.SerializedName

data class NewsResult(
    @SerializedName("status") var status: String,
    @SerializedName("copyright") var copyright: String,
    @SerializedName("num_results") var numResults: Int,
    @SerializedName("results") var results: List<NewsList>
)