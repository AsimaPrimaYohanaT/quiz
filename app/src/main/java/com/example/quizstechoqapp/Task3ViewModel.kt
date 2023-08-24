package com.example.quizstechoqapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizstechoqapp.api.ApiConfig
import com.example.quizstechoqapp.response.MyResponse
import com.example.quizstechoqapp.response.ResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Task3ViewModel : ViewModel()  {

    private val _user = MutableLiveData<List<ResponseItem>>()
    val user: LiveData<List<ResponseItem>> = _user

    init {
        getUser()
    }
    private fun getUser() {
        val client = ApiConfig.getApiService().getPhotos()
        client.enqueue(object : Callback<MyResponse> {
            override fun onResponse(
                call: Call<MyResponse>,
                response: Response<MyResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _user.value = responseBody.response
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }
            }
            override fun onFailure(call: Call<MyResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        }
        )
    }
}