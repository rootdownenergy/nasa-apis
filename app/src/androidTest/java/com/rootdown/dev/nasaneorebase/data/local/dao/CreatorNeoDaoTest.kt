package com.rootdown.dev.nasaneorebase.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.rootdown.dev.nasaneorebase.data.local.AppDatabase
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import com.rootdown.dev.nasaneorebase.data.local.util.getOrAwaitValue
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
class CreatorNeoDaoTest {

    //rule
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /*
    * ini db
    * ini dao
    * */
    private lateinit var database: AppDatabase
    private lateinit var dao: CreatorNeoDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.creatorNeoDao()
    }

    @Test
    fun insertCreatorNeo() = runTest {
        val ls: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
        val item: CreatorNeoEntity = CreatorNeoEntity(
            neoId = 1,
            id = "334234",
            refId = "135",
            name = "TESTTDD",
            url = "testtdd.com"
        )
        dao.insertNeoItem(item)
        val allitem = dao.getNeo().asLiveData().getOrAwaitValue()
        assertThat(allitem).contains(item)
    }
    @Test
    fun getByIdCreatorNeo() = runTest {
        val ls: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
        val item1: CreatorNeoEntity = CreatorNeoEntity(
            neoId = 1,
            id = "334234",
            refId = "135",
            name = "TESTTDD",
            url = "testtdd.com"
        )
        val item2: CreatorNeoEntity = CreatorNeoEntity(
            neoId = 2,
            id = "32124",
            refId = "2145",
            name = "TESTTDD",
            url = "testtdd.com"
        )
        val item3: CreatorNeoEntity = CreatorNeoEntity(
            neoId = 3,
            id = "334234534",
            refId = "5635",
            name = "TESTTDD",
            url = "testtdd.com"
        )
        dao.insertNeoItem(item1)
        dao.insertNeoItem(item2)
        dao.insertNeoItem(item3)
        val result = dao.neoById(item2.neoId).asLiveData().getOrAwaitValue()
        assertThat(item2.neoId).isEqualTo(item2.neoId)
    }
    @Test
    fun updateCreatorNeo() = runTest {
        val ls: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
        val item: CreatorNeoEntity = CreatorNeoEntity(
            neoId = 1,
            id = "334234",
            refId = "135",
            name = "TESTTDD",
            url = "testtdd.com"
        )
        val itemMod = item.copy(neoId = 1, id = "42344", refId = "55345", name = "TEST-TDD", url = "www.testtdd.com")
        dao.insertNeoItem(item)
        dao.updateCreatorNeo(itemMod)
        val result = dao.getNeo().asLiveData().getOrAwaitValue()
        assertThat(result).doesNotContain(item)
    }
    @Test
    fun deleteCreatorNeo() = runTest {
        val ls: MutableList<String> = mutableListOf("jfhpisuadh", "hpiuerh")
        val item: CreatorNeoEntity = CreatorNeoEntity(
            neoId = 1,
            id = "334234",
            refId = "135",
            name = "TESTTDD",
            url = "testtdd.com"
        )
        dao.insertNeoItem(item)
        dao.deleteNeoItem(item.neoId)
        val result = dao.getNeo().asLiveData().getOrAwaitValue()
        assertThat(result).doesNotContain(item)
    }

    @After
    fun teardown(){
        database.close()
    }
}