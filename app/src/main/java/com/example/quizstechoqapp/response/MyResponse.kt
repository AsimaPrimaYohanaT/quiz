package com.example.quizstechoqapp.response

import com.google.gson.annotations.SerializedName

data class ResponseItem(

	@field:SerializedName("albumId")
	val albumId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String? = null
)

data class MyResponse(

	@field:SerializedName("response")
	val response: List<ResponseItem>
)
