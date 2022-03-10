package com.harshit.quantumAssessment.pojo.entities


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    var author: Any? = null,
    @SerializedName("content")
    var content: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("publishedAt")
    var publishedAt: String = "",
    @SerializedName("source")
    var source: Source = Source(),
    @SerializedName("title")
    var title: String = "",
    @SerializedName("url")
    var url: String = "",
    @SerializedName("urlToImage")
    var urlToImage: String? = null
)