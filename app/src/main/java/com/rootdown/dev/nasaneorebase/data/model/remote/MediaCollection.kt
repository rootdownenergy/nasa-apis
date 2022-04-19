package com.rootdown.dev.nasaneorebase.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaCollection(
    @SerializedName("version")
    val version: String,
    @SerializedName("href")
    val href: String,
    @SerializedName("items")
    val items: MutableList<String> = mutableListOf()
) : Parcelable