package com.fallenangel.android.mobile.domain.interactor

import com.fallenangel.android.mobile.domain.model.ImageFile
import com.fallenangel.android.mobile.domain.repository.Downloader
import com.fallenangel.android.mobile.domain.repository.ImageRepository
import com.fallenangel.android.mobile.domain.utils.SchedulersProvider
import io.reactivex.Single

/**
 * Created by NineB on 10/29/2018.
 */

class RandomImageInteractor (
        private val imageRepository: ImageRepository,
        private val downloader: Downloader,
        private val schedulersProvider: SchedulersProvider
) {

    fun executeFetchRandomImage(): Single<ImageFile>{
        return imageRepository.getRandomImageUrl()
                .flatMap { downloader.download(it) }
                .subscribeOn(schedulersProvider.io())
    }

}