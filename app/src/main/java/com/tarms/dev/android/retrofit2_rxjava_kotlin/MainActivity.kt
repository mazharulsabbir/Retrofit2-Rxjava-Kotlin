package com.tarms.dev.android.retrofit2_rxjava_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    lateinit var jsonPlaceholderApi: JsonPlaceholderApi
    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitClient.instance

        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)

        compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            jsonPlaceholderApi.posts
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::initData, this::handleError)
        )
    }

    private fun handleError(error: Throwable) {
        Logger.getLogger(MainActivity::class.java.name).warning("   Error: $error.localizedMessage")
    }

    private fun initData(posts: List<Post>?) {
        for (i in 0..posts!!.size)
            Logger.getLogger(MainActivity::class.java.name).warning("   #Title: ${posts[i].title}")
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
