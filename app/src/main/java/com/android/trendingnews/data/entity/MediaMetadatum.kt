package com.android.trendingnews.data.entity

import com.google.gson.annotations.SerializedName

data class MediaMetadatum(
    @SerializedName("url") var url: String,
    @SerializedName("format") var format: String,
    @SerializedName("height") var height: Int,
    @SerializedName("width") var width: Int
)