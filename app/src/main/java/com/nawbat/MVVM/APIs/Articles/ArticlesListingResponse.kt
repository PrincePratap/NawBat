package com.nawbat.MVVM.APIs.Articles

data class ArticlesListingResponse(
    val code: Int,
    val count: Int,
    val `data`: List<DataArticles>,
    val message: String,
    val statusCode: Int
)
data class DataArticles(
    val articleImageDetails: List<ArticleImageDetail>,
    val article_id: Int,
    val author: String,
    val created_at: String,
    val description: String,
    val is_active: Int,
    val is_liked: Int,
    val like_counts: Int,
    val title: String,
    val updated_at: String,
    val written_at: String
)
data class ArticleImageDetail(
    val article_image_id: Int,
    val created_at: String,
    val image: String,
    val updated_at: String
)