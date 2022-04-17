package com.rootdown.dev.nasaneorebase.data.model.remote

import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("near_earth_objects")
    val nearEarthObjects: Map<String, List<Neo>>
)