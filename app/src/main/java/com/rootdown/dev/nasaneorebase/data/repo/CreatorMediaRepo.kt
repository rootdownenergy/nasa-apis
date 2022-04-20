package com.rootdown.dev.nasaneorebase.data.repo

import androidx.lifecycle.LiveData
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
import kotlinx.coroutines.flow.Flow

interface CreatorMediaRepo {
    suspend fun getCreatorMedia(): Flow<List<CreatorMediaEntity>>
    suspend fun getCreatorMediaById(mediaId: Int): LiveData<CreatorMediaEntity>
    suspend fun insertCreatorMedia(media: CreatorMediaEntity)
    suspend fun updateCreatorMedia(media: CreatorMediaEntity)
    suspend fun deleteCreatorMedia(media: CreatorMediaEntity)
}