package com.rootdown.dev.nasaneorebase.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Neo(
    @SerializedName("id")
    val id: String,

    @SerializedName("neo_reference_id")
    val refId: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("nasa_jpl_url")
    val url: String
) : Parcelable