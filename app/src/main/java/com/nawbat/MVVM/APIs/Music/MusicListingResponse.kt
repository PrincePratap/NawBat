package com.nawbat.MVVM.APIs.Music

data class MusicListingResponse(
    val code: Int,
    val count: Int,
    val `data`: List<DataMusic>,
    val message: String,
    val statusCode: Int
)
data class DataMusic(
    val created_at: String,
    val duration: String,
    val image: String,
    val is_active: Int,
    val music_id: Int,
    val music_name: String,
    val orchestra_band_id: Int,
    val track_file: String,
    val updated_at: String
)