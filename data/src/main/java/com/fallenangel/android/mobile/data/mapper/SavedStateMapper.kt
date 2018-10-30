package com.fallenangel.android.mobile.data.mapper

import android.os.Bundle
import com.fallenangel.android.mobile.domain.model.ImageFile

/**
 * Created by NineB on 10/30/2018.
 */
class SavedStateMapper {

    companion object {
        val SAVED_IMG_STATE_PATH_KEY = "SAVED_IMG_STATE_PATH_KEY"
        val SAVED_IMG_STATE_SIZE_KEY = "SAVED_IMG_STATE_SIZE_KEY"
    }

    fun map(savedInstanceState: Bundle?) = ImageFile(
                savedInstanceState?.getString(SAVED_IMG_STATE_PATH_KEY, "")!!,
                savedInstanceState.getLong(SAVED_IMG_STATE_SIZE_KEY, -1)
    )

}