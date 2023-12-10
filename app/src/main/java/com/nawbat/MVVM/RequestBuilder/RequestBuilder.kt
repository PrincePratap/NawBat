package com.nawbat.MVVM.RequestBuilder

import com.nawbat.MVVM.APIs.Articles.ArticlesListingResponse
import com.nawbat.MVVM.APIs.Event.EventListingResponse
import com.nawbat.MVVM.APIs.Login.LoginRequest.LoginRequest
import com.nawbat.MVVM.APIs.Login.LoginResponse.LogInResponse
import com.nawbat.MVVM.APIs.Music.MusicListingResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

object RequestBuilder {
    private val intercepter = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder().apply { this.addInterceptor(intercepter) }.build()
    private const val BASE_URL = "http://52.66.165.178:4004"
    val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create())
            .build()

}
interface  AuthService{
//    @POST("/api/user/register")
//    fun getUserRegister(@Body userRegisterRequest: userRegisterRequest) : Call<UserRegisterResponse>
//
//    @POST("/api/user/verifyOtp")
//    fun getOtp(@Header("authtoken") token : String, @Body otpRequest: OtpRequest) : Call<OtpResponse>
//
    @POST("/api/user/userLogin")
    fun getLogin(@Body body: LoginRequest)  : Call<LogInResponse>
//
//    @GET("/api/user/userProfile")
//    fun getUserProfile(@Header("authtoken") token : String) : Call<UserProfileResponse>
//
//    @POST("/api/user/logout")
//    fun getLogout(@Header("authtoken") token : String, @Body body: LogoutRequest) : Call<LogoutResponse>
}
interface MainService{
    @GET("/api/user/articleListing?page=1&limit=&search=")
    fun getArticleListing(@Header("authtoken") token : String ) : Call<ArticlesListingResponse>

    @GET("/api/user/eventListing")
    fun getEventListing( @Header("authtoken") token: String) : Call<EventListingResponse>

    @GET("/api/user/musicListing?page=&limit=&search")
    fun getMusicListing( @Header("authtoken") token : String) : Call<MusicListingResponse>


}