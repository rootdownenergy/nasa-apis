package com.rootdown.dev.nasaneorebase.data.local.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "creator_media")
data class CreatorMediaEntity(
    @PrimaryKey(autoGenerate = true)
    val mediaId: Int = 0,
    val album: MutableList<String> = mutableListOf(),
    val center: String? = "",
    val dateCreated: String? = "",
    val description: String? = "",
    val description508: String? = "",
    val keywords: MutableList<String> = mutableListOf(),
    val location: String? = "",
    val mediaType: String? = "",
    val nasaId: String? = "",
    val photographer: String? = "",
    val secondaryCreator: String? = "",
    val title: String? = ""
) : Parcelable

