package com.harshit.quantumAssessment.pojo.response


import com.google.gson.annotations.SerializedName
import com.harshit.quantumAssessment.pojo.entities.Article

data class ResponseGetNews(
    @SerializedName("articles")
    var articles: List<Article> = listOf(),
    @SerializedName("status")
    var status: String = "",
    @SerializedName("totalResults")
    var totalResults: Int = 0
)