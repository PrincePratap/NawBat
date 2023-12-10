package com.nawbat.MVVM.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nawbat.MVVM.APIs.Articles.ArticlesListingResponse
import com.nawbat.MVVM.APIs.Event.EventListingResponse
import com.nawbat.MVVM.APIs.Music.MusicListingResponse
import com.nawbat.MVVM.Repo.MyMainRepo
import javax.inject.Inject

class MyMainViewModel  @Inject constructor(private val repo: MyMainRepo): ViewModel() {


    val articleListingResponseLiveData: LiveData<ArticlesListingResponse>
        get() = repo.articleListingLiveData

    val eventListingResponseLiveData : LiveData<EventListingResponse>
        get() = repo.eventListingLiveData


    val musicListingResponseLiveData : LiveData<MusicListingResponse>
        get() = repo.musicListingLiveData

    fun getArticleListingResponse(token : String){
        repo.getArticleListing(token)
    }

    fun getEventListing(token: String){
        repo.getEventListing(token)
    }
    fun getMusicListing(token: String){
        repo.getMusicListing(token)
    }



}