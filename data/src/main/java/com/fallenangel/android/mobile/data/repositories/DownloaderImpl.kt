package com.fallenangel.android.mobile.data.repositories

import com.fallenangel.android.mobile.data.fileystem.DownloadFileManager
import com.fallenangel.android.mobile.domain.model.ImageFile
import com.fallenangel.android.mobile.domain.repository.Downloader
import io.reactivex.Single

/**
 * Created by NineB on 10/29/2018.
 */
class DownloaderImpl(
        private var downloadFileManager: DownloadFileManager
) : Downloader {

    override fun download(url: String): Single<ImageFile> {
        return downloadFileManager.download(url)
    }

}