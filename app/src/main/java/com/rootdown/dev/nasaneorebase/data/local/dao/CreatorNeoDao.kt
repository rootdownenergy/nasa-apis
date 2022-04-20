package com.rootdown.dev.nasaneorebase.data.local.dao

import androidx.room.*
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CreatorNeoDao {
    @Query("SELECT COUNT(*) FROM creator_neo")
    fun getCountNeo(): Int

    @Query("select * from creator_neo")
    fun getNeo(): Flow<List<CreatorNeoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNeoItem(neo: CreatorNeoEntity)

    @Query("DELETE FROM creator_neo WHERE neoId = :neoId")
    suspend fun deleteNeoItem(neoId: Int)

    @Update
    suspend fun updateCreatorNeo(neo: CreatorNeoEntity)

    @Query("SELECT * FROM creator_neo WHERE neoId = :neoId")
    fun neoById(neoId: Int): Flow<CreatorNeoEntity>
}