package com.tarms.dev.android.retrofit2_rxjava_kotlin


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body") val body: String,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("userId") val userId: Int
)