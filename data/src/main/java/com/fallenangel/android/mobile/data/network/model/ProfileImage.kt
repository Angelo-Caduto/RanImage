package com.fallenangel.android.mobile.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by NineB on 10/30/2018.
 */
data class ProfileImage (

        @SerializedName("small")
        @Expose
        private var small: String,
        @SerializedName("medium")
        @Expose
        private var medium: String,
        @SerializedName("large")
        @Expose
        private var large: String

)