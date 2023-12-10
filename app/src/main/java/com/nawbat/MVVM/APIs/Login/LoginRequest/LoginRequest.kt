package com.nawbat.MVVM.APIs.Login.LoginRequest

data class LoginRequest(
    val device_id: String,
    val device_token: String,
    val device_type: String,
    val email: String,
    val password: String
)

