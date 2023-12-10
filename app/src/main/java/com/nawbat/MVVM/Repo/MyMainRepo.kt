package com.nawbat.MVVM.Repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nawbat.MVVM.APIs.Articles.ArticlesListingResponse
import com.nawbat.MVVM.APIs.Event.EventListingResponse
import com.nawbat.MVVM.APIs.Music.MusicListingResponse
import com.nawbat.MVVM.RequestBuilder.MainService
import com.nawbat.MVVM.RequestBuilder.RequestBuilder
import dagger.hilt.android.qualifiers.ActivityContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MyMainRepo@Inject constructor(@ActivityContext val context: Context)  {

    private val request: MainService = RequestBuilder.retrofit.create(MainService::class.java)

    private val _articleListingResponse = MutableLiveData<ArticlesListingResponse>()
    private  val  _eventListingResponse = MutableLiveData<EventListingResponse>()
    private  val _musicListingResponse = MutableLiveData<MusicListingResponse>()






    val  articleListingLiveData : LiveData<ArticlesListingResponse>
        get() =  _articleListingResponse


    val eventListingLiveData : LiveData<EventListingResponse>
        get() = _eventListingResponse


    val musicListingLiveData : LiveData<MusicListingResponse>
        get() = _musicListingResponse


    fun getArticleListing(token : String){

        var result = request.getArticleListing(token)

        result.enqueue(object : Callback<ArticlesListingResponse?> {
            override fun onResponse(
                call: Call<ArticlesListingResponse?>,
                response: Response<ArticlesListingResponse?>
            ) {

                _articleListingResponse.postValue(response.body())
            }
            override fun onFailure(call: Call<ArticlesListingResponse?>, t: Throwable) {
                Toast.makeText(context,t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun getEventListing(token: String){
        val result = request.getEventListing(token)
        result.enqueue(object : Callback<EventListingResponse?> {
            override fun onResponse(
                call: Call<EventListingResponse?>,
                response: Response<EventListingResponse?>
            ) {
                _eventListingResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<EventListingResponse?>, t: Throwable) {
                Toast.makeText(context,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }


    fun getMusicListing(token: String){
        var result = request.getMusicListing(token)

        result.enqueue(object : Callback<MusicListingResponse?> {
            override fun onResponse(
                call: Call<MusicListingResponse?>,
                response: Response<MusicListingResponse?>
            ) {
                _musicListingResponse.postValue(response.body())

            }
            override fun onFailure(call: Call<MusicListingResponse?>, t: Throwable) {
                Toast.makeText(context,t.message,Toast.LENGTH_LONG).show()

            }
        })
    }





}