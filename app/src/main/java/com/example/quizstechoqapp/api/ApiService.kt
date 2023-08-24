package com.example.quizstechoqapp.api

import com.example.quizstechoqapp.response.ResponseItem
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("photos")
    fun getPhotos(): Call<List<ResponseItem>>
}