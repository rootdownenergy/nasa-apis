package com.rootdown.dev.nasaneorebase.data.local.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "creator_neo")
data class CreatorNeoEntity(
    @PrimaryKey(autoGenerate = true)
    val neoId: Int = 0,
    val id: String? = "",
    val refId: String? = "",
    val name: String? = "",
    val url: String? = ""
) : Parcelable