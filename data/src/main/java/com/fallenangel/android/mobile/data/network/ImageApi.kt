package com.fallenangel.android.mobile.data.network

import com.fallenangel.android.mobile.data.network.model.ImageRestModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.GET

/**
 * Created by NineB on 10/29/2018.
 */
interface ImageApi {

//    @GET("photos/random?client_id=9888003dc7e1e94422957ec822a20f229860942edcb649d65fd80327d297e3cb")
    @GET("photos/random?client_id=d236a9c341529a3c3ad6321ec8321a065227d38000187f880d7baa4f0f44d599")
    fun getRandomImage(): Single<ImageRestModel>

}