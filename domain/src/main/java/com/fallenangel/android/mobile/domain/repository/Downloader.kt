package com.fallenangel.android.mobile.domain.repository

import com.fallenangel.android.mobile.domain.model.ImageFile
import io.reactivex.Single

/**
 * Created by NineB on 10/29/2018.
 */
interface Downloader {
    fun download(url: String): Single<ImageFile>
}