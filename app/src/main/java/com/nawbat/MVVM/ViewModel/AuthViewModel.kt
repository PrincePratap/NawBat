package com.nawbat.MVVM.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nawbat.MVVM.APIs.Login.LoginRequest.LoginRequest
import com.nawbat.MVVM.APIs.Login.LoginResponse.LogInResponse
import com.nawbat.MVVM.Repo.AuthRepo
import javax.inject.Inject

class AuthViewModel @Inject constructor(private val repo: AuthRepo): ViewModel() {


    val loginResponseLiveData : LiveData<LogInResponse>
        get() = repo.logInLiveData

    fun getLoginResponse(body: LoginRequest){
        repo.getLogin(body)
    }

}