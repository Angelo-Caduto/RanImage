package com.fallenangel.android.mobile.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by NineB on 10/30/2018.
 */
data class Links_ (
        @SerializedName("self")
        @Expose
        private var self: String,
        @SerializedName("html")
        @Expose
        private var html: String,
        @SerializedName("photos")
        @Expose
        private var photos: String,
        @SerializedName("likes")
        @Expose
        private var likes: String,
        @SerializedName("portfolio")
        @Expose
        private var portfolio: String,
        @SerializedName("following")
        @Expose
        private var following: String,
        @SerializedName("followers")
        @Expose
        private var followers: String
)