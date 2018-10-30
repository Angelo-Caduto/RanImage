package com.fallenangel.android.mobile.data.mapper

import com.fallenangel.android.mobile.data.network.model.ImageRestModel
/**
 * Created by NineB on 10/29/2018.
 */
class IRMToUrlMapper {

    fun map(imgRestModel: ImageRestModel) = imgRestModel.urls.full

}