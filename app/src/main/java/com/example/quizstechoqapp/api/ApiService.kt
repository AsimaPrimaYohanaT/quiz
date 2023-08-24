package com.example.quizstechoqapp.api

import com.example.quizstechoqapp.response.MyResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("photos")
    fun getPhotos(): Call<MyResponse>
}