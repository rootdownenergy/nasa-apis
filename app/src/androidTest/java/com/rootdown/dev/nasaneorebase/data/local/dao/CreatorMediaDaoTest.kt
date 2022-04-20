package com.rootdown.dev.nasaneorebase.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.rootdown.dev.nasaneorebase.data.local.AppDatabase
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class CreatorMediaDaoTest {

    //rule
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /*
    * ini db
    * ini dao
    * */
    private lateinit var database: AppDatabase
    private lateinit var dao: CreatorMediaDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.creatorMediaDao()
    }

    @Test
    fun insertCreatorMedia() = runTest {
        val ls: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
    }
    @Test
    fun getByIdCreatorMedia() = runTest {
        val ls1: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
        val ls2: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh","gse","erety")
        val ls3: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh","werwer")
        val item1: CreatorMediaEntity = CreatorMediaEntity(mediaId = 1, album = ls1)
        val item2: CreatorMediaEntity = CreatorMediaEntity(mediaId = 1, album = ls2)
        val item3: CreatorMediaEntity = CreatorMediaEntity(mediaId = 1, album = ls3)

    }
    @Test
    fun updateCreatorMedia() = runTest {
        val ls: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")

    }
    @Test
    fun deleteCreatorMedia() = runTest {
        val ls: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")

    }

    @After
    fun teardown(){
        database.close()
    }
}