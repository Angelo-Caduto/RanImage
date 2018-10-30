package com.fallenangel.android.mobile.data.fileystem

import android.content.Context
import android.os.Environment
import com.fallenangel.android.mobile.domain.model.ImageFile
import io.reactivex.Single
import java.io.File
import com.esafirm.rxdownloader.RxDownloader
import com.fallenangel.android.mobile.data.mapper.ImageFileMapper


/**
 * Created by NineB on 10/29/2018.
 */
class DownloadFileManager(val context: Context, val rxDownloader: RxDownloader) {

    private val fileName = "random_image.jpg"
    private val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath + File.separator + "RandomImage/"

    fun download(url: String) : Single<ImageFile>{
        return rxDownloader
                .downloadInFilesDir(url, fileName, path, "image/jpg", true)
                .map { ImageFileMapper().map(it) }
                .firstOrError()
    }

}