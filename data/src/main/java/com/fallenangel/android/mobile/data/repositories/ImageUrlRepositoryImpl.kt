package com.fallenangel.android.mobile.data.repositories

import com.fallenangel.android.mobile.data.mapper.IRMToUrlMapper
import com.fallenangel.android.mobile.data.network.ImageApi
import com.fallenangel.android.mobile.domain.repository.ImageRepository
import io.reactivex.Single

/**
 * Created by NineB on 10/29/2018.
 */
class ImageUrlRepositoryImpl(private val imageApi: ImageApi) : ImageRepository {

    override fun getRandomImageUrl(): Single<String> {
        return imageApi.getRandomImage().map { IRMToUrlMapper().map(it) }
    }

}