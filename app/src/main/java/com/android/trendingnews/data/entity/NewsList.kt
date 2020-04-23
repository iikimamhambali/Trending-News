package com.android.trendingnews.data.entity

import com.google.gson.annotations.SerializedName
import java.util.*

data class NewsList(
    @SerializedName("uri") var uri: String,
    @SerializedName("url") var url: String,
    @SerializedName("id") var id: Float,
    @SerializedName("asset_id") var assetId: Float,
    @SerializedName("source") var source: String,
    @SerializedName("published_date") var publishedDate: String,
    @SerializedName("updated") var updated: String,
    @SerializedName("section") var section: String,
    @SerializedName("subsection") var subsection: String,
    @SerializedName("nytdsection") var nytdsection: String,
    @SerializedName("adx_keywords") var adxKeywords: String,
    @SerializedName("column") var column: Objects,
    @SerializedName("byline") var byline: String,
    @SerializedName("type") var type: String,
    @SerializedName("title") var title: String,
    @SerializedName("abstract") var abstract: String,
    @SerializedName("des_facet") var desFacet: List<String>,
    @SerializedName("org_facet") var orgFacet: List<String>,
    @SerializedName("per_facet") var perFacet: List<String>,
    @SerializedName("geo_facet") var geoFacet: List<String>,
    @SerializedName("media") var media: List<Medium>,
    @SerializedName("eta_id") var etaId: Int
)