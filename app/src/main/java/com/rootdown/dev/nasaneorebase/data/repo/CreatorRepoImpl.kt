package com.rootdown.dev.nasaneorebase.data.repo

import androidx.lifecycle.LiveData
import com.rootdown.dev.nasaneorebase.data.local.dao.CreatorMediaDao
import com.rootdown.dev.nasaneorebase.data.local.dao.CreatorNeoDao
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreatorRepoImpl @Inject constructor(
    private val daoNeo: CreatorNeoDao,
    private val daoMedia: CreatorMediaDao
): CreatorMediaRepo, CreatorNeoRepo {
    override suspend fun getCreatorMedia(): Flow<List<CreatorMediaEntity>> {
        return daoMedia.getMedia()
    }

    override suspend fun getCreatorMediaById(mediaId: Int): LiveData<CreatorMediaEntity> {
        return daoMedia.mediaById(mediaId)
    }

    override suspend fun insertCreatorMedia(media: CreatorMediaEntity) {
        return daoMedia.insertMediaItem(media)
    }

    override suspend fun updateCreatorMedia(media: CreatorMediaEntity) {
        return daoMedia.updateCreator(media)
    }

    override suspend fun deleteCreatorMedia(media: CreatorMediaEntity) {
        return daoMedia.deleteMediaItem(media.mediaId)
    }

    override suspend fun getCreatorNeo(): Flow<List<CreatorNeoEntity>> {
       return daoNeo.getNeo()
    }

    override suspend fun getCreatorNeoById(neoId: Int): LiveData<CreatorNeoEntity> {
        return daoNeo.neoById(neoId)
    }

    override suspend fun insertCreatorNeo(neo: CreatorNeoEntity) {
        return daoNeo.insertNeoItem(neo)
    }

    override suspend fun updateCreatorNeo(neo: CreatorNeoEntity) {
        return daoNeo.updateCreatorNeo(neo)
    }

    override suspend fun deleteCreatorNeo(neo: CreatorNeoEntity) {
        return daoNeo.deleteNeoItem(neo.neoId)
    }
}