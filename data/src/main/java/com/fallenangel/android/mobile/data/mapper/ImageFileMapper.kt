package com.fallenangel.android.mobile.data.mapper

import android.net.Uri
import com.fallenangel.android.mobile.domain.model.ImageFile
import java.io.File

/**
 * Created by NineB on 10/29/2018.
 */
class ImageFileMapper {

    fun map(uri: String): ImageFile {
        val path = Uri.parse(uri).path
        return ImageFile(path, File(path).length())
    }

}