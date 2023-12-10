package com.nawbat.MVVM.Repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nawbat.MVVM.APIs.Login.LoginRequest.LoginRequest
import com.nawbat.MVVM.APIs.Login.LoginResponse.LogInResponse
import com.nawbat.MVVM.RequestBuilder.AuthService
import com.nawbat.MVVM.RequestBuilder.RequestBuilder
import dagger.hilt.android.qualifiers.ActivityContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthRepo  @Inject constructor(@ActivityContext val context: Context){


    private val request: AuthService = RequestBuilder.retrofit.create(AuthService::class.java)


    private val _logInResponse = MutableLiveData<LogInResponse>()



    val logInLiveData : LiveData<LogInResponse>
        get() = _logInResponse




    fun getLogin(body: LoginRequest){
        val result = request.getLogin(body)
        result.enqueue(object : Callback<LogInResponse?> {
            override fun onResponse(
                call: Call<LogInResponse?>,
                response: Response<LogInResponse?>
            ) {

                _logInResponse.postValue(response.body())

            }
            override fun onFailure(call: Call<LogInResponse?>, t: Throwable) {

            }
        })
    }


}