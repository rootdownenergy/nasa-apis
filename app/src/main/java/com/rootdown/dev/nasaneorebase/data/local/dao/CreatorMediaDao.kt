package com.rootdown.dev.nasaneorebase.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CreatorMediaDao {
    @Query("SELECT COUNT(*) FROM creator_media")
    fun getCount(): Int

    @Query("select * from creator_media")
    fun getMedia(): Flow<List<CreatorMediaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMediaItem(media: CreatorMediaEntity)

    @Query("DELETE FROM creator_media WHERE mediaId = :mediaId")
    suspend fun deleteMediaItem(mediaId: Int)

    @Update
    suspend fun updateCreator(media: CreatorMediaEntity)

    @Query("SELECT * FROM creator_media WHERE mediaId = :mediaId")
    fun mediaById(mediaId: Int): Flow<CreatorMediaEntity>

}