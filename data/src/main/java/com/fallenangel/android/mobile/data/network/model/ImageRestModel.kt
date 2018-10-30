package com.fallenangel.android.mobile.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by NineB on 10/29/2018.
 */
data class ImageRestModel(
        @SerializedName("id")
        @Expose
        var id: String,
        @SerializedName("created_at")
        @Expose
        var createdAt: String,
        @SerializedName("updated_at")
        @Expose
        var updatedAt: String,
        @SerializedName("width")
        @Expose
        var width: Int,
        @SerializedName("height")
        @Expose
        var height: Int,
        @SerializedName("color")
        @Expose
        var color: String,
        @SerializedName("description")
        @Expose
        var description: String,
        @SerializedName("urls")
        @Expose
        var urls: Urls,
        @SerializedName("links")
        @Expose
        var links: Links,
        @SerializedName("categories")
        @Expose
        var categories:  List<Any>,
        @SerializedName("sponsored")
        @Expose
        var sponsored: Boolean,
        @SerializedName("sponsored_by")
        @Expose
        var sponsoredBy: Any,
        @SerializedName("sponsored_impressions_id")
        @Expose
        var sponsoredImpressionsId: Any,
        @SerializedName("likes")
        @Expose
        var likes: Int,
        @SerializedName("liked_by_user")
        @Expose
        var likedByUser: Boolean,
        @SerializedName("current_user_collections")
        @Expose
        var currentUserCollections: List<Any>,
        @SerializedName("slug")
        @Expose
        var slug: Any,
        @SerializedName("user")
        @Expose
        var user: User,
        @SerializedName("exif")
        @Expose
        var exif: Exif,
        @SerializedName("views")
        @Expose
        var views: Int,
        @SerializedName("downloads")
        @Expose
        var downloads: Int
)