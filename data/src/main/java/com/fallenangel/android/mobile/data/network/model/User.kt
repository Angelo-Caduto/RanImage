package com.fallenangel.android.mobile.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by NineB on 10/30/2018.
 */
data class User (
        @SerializedName("id")
        @Expose
        private var id: String,
        @SerializedName("updated_at")
        @Expose
        private var updatedAt: String,
        @SerializedName("username")
        @Expose
        private var username: String,
        @SerializedName("name")
        @Expose
        private var name: String,
        @SerializedName("first_name")
        @Expose
        private var firstName: String,
        @SerializedName("last_name")
        @Expose
        private var lastName: String,
        @SerializedName("twitter_username")
        @Expose
        private var twitterUsername: Any,
        @SerializedName("portfolio_url")
        @Expose
        private var portfolioUrl: Any,
        @SerializedName("bio")
        @Expose
        private var bio: Any,
        @SerializedName("location")
        @Expose
        private var location: Any,
        @SerializedName("links")
        @Expose
        private var links: Links_,
        @SerializedName("profile_image")
        @Expose
        private var profileImage: ProfileImage,
        @SerializedName("instagram_username")
        @Expose
        private var instagramUsername: Any,
        @SerializedName("total_collections")
        @Expose
        private var totalCollections: Int,
        @SerializedName("total_likes")
        @Expose
        private var totalLikes: Int,
        @SerializedName("total_photos")
        @Expose
        private var totalPhotos: Int
)