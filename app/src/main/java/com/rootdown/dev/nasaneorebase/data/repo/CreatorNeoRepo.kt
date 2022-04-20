package com.rootdown.dev.nasaneorebase.data.repo

import androidx.lifecycle.LiveData
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import kotlinx.coroutines.flow.Flow

interface CreatorNeoRepo {
    suspend fun getCreatorNeo(): Flow<List<CreatorNeoEntity>>
    suspend fun getCreatorNeoById(neoId: Int): LiveData<CreatorNeoEntity>
    suspend fun insertCreatorNeo(neo: CreatorNeoEntity)
    suspend fun updateCreatorNeo(neo: CreatorNeoEntity)
    suspend fun deleteCreatorNeo(neo: CreatorNeoEntity)
}