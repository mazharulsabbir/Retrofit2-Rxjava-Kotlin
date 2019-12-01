package com.tarms.dev.android.retrofit2_rxjava_kotlin

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

object RetrofitClient {
    private var myInstance: Retrofit? = null

    val instance: Retrofit
        get() {
            if (myInstance == null) {
                myInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }

            return myInstance!!
        }
}