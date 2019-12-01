package com.tarms.dev.android.retrofit2_rxjava_kotlin

import io.reactivex.Observable
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @get:GET("/posts")
    val posts: Observable<List<Post>>

}