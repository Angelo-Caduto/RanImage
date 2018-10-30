package com.fallenangel.android.mobile.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by NineB on 10/30/2018.
 */
data class Exif (
        @SerializedName("make")
        @Expose
        private var make: String,
        @SerializedName("model")
        @Expose
        private var model: String,
        @SerializedName("exposure_time")
        @Expose
        private var exposureTime: String,
        @SerializedName("aperture")
        @Expose
        private var aperture: String,
        @SerializedName("focal_length")
        @Expose
        private var focalLength: String,
        @SerializedName("iso")
        @Expose
        private var iso: Int
)