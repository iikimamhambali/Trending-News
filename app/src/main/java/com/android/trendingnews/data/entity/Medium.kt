package com.android.trendingnews.data.entity

import com.google.gson.annotations.SerializedName

data class Medium(
    @SerializedName("type") var type: String,
    @SerializedName("subtype") var subtype: String,
    @SerializedName("caption") var caption: String,
    @SerializedName("copyright") var copyright: String,
    @SerializedName("approved_for_syndication") var approvedSyndication: Int,
    @SerializedName("media-metadata") var mediaMetadata: List<MediaMetadatum>
)