package com.example.quizstechoqapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizstechoqapp.api.ApiConfig
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
        client.enqueue(object : Callback<List<ResponseItem>> {
            override fun onResponse(
                call: Call<List<ResponseItem>>,
                response: Response<List<ResponseItem>>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _user.value = response.body()
                    } else {
                        Log.e(TAG, "onFailure: ${response.message()}")
                    }
                }
            }
            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        }
        )
    }
}