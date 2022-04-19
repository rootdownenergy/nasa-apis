package com.rootdown.dev.nasaneorebase.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    @SerializedName("center")
    val center: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?
) : Parcelable