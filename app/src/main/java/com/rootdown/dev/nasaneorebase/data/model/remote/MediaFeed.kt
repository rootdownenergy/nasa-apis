package com.rootdown.dev.nasaneorebase.data.model.remote

import com.google.gson.annotations.SerializedName

data class MediaFeed(
    @SerializedName("collection")
    val collection: List<MediaRoot>
)