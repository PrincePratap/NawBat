package com.nawbat.MVVM.APIs.Login.LoginResponse

data class LogInResponse(
    val code: Int,
    val count: CountX,
    val `data`: DataX,
    val message: String,
    val statusCode: Int
)
data class DataX(
    val auth_token: String,
    val result: Result
)
data class Result(
    val added_by_id: Any,
    val apple_id: Any,
    val card_expiry_date: String,
    val card_holder_name: String,
    val card_number: Int,
    val created_at: String,
    val cvv: Int,
    val dob: String,
    val email: String,
    val facebook_id: Any,
    val first_name: String,
    val gender: String,
    val google_id: Any,
    val is_active: Int,
    val is_email_verified: Int,
    val is_logged_out_from_all_devices: Int,
    val is_verified: Int,
    val language_id: Int,
    val last_name: String,
    val notification_permission: Int,
    val profile_pic: String,
    val social_type: String,
    val source: String,
    val updated_at: String,
    val user_id: Int,
    val user_type: Int
)

class CountX