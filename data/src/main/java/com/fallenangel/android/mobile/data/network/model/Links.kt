package com.fallenangel.android.mobile.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by NineB on 10/30/2018.
 */
data class Links (

        @SerializedName("self")
        @Expose
        private var self: String,
        @SerializedName("html")
        @Expose
        private var html: String,
        @SerializedName("download")
        @Expose
        private var download: String,
        @SerializedName("download_location")
        @Expose
        private var downloadLocation: String

)