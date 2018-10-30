package com.fallenangel.android.mobile.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

/**
 * Created by NineB on 10/29/2018.
 */
open class RetrofitClient constructor() {

    private val baseUrl = "https://api.unsplash.com/"

    fun getImageApi(): ImageApi{

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ImageApi::class.java)
    }

}