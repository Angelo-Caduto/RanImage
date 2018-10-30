package com.fallenangel.android.mobile.domain.repository

import io.reactivex.Single

/**
 * Created by NineB on 10/29/2018.
 */
interface ImageRepository {
    fun getRandomImageUrl(): Single<String>
}