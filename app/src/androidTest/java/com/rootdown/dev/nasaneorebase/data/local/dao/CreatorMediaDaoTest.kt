package com.rootdown.dev.nasaneorebase.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.rootdown.dev.nasaneorebase.data.local.AppDatabase
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
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
        val lsAlt: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh","werwehro","weif")
        val item1: CreatorMediaEntity = CreatorMediaEntity(
            mediaId = 1,
            album = ls,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "stronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        dao.insertMediaItem(item1)
        val result = dao.getMedia().asLiveData().getOrAwaitValue()
        assertThat(result).contains(item1)
    }
    @Test
    fun getByIdCreatorMedia() = runTest {
        val ls1: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
        val ls2: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh","gse","erety")
        val ls3: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh","werwer")
        val lsAlt1: MutableList<String> = mutableListOf("jfhpisttuadh","hpiuerh","werwerro")
        val lsAlt2: MutableList<String> = mutableListOf("jfhwerdh","hrwerrh","werwehro","weif")
        val lsAlt3: MutableList<String> = mutableListOf("jfhpisuertadh","werwehro","weif","eqwe","34erf23wef")
        val item1: CreatorMediaEntity = CreatorMediaEntity(
            mediaId = 1,
            album = ls1,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "stronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt1,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        val item2: CreatorMediaEntity = CreatorMediaEntity(
            mediaId = 1,
            album = ls2,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "stronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt2,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        val item3: CreatorMediaEntity = CreatorMediaEntity(
            mediaId = 1,
            album = ls3,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "stronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt3,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        dao.insertMediaItem(item1)
        dao.insertMediaItem(item2)
        dao.insertMediaItem(item3)
        val result = dao.mediaById(item2.mediaId).asLiveData().getOrAwaitValue()
        assertThat(result.mediaId).isEqualTo(item2.mediaId)
    }
    @Test
    fun updateCreatorMedia() = runTest {
        val ls1: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
        val lsAlt1: MutableList<String> = mutableListOf("jfhpisttuadh","hpiuerh","werwerro")
        val ls1Mod: MutableList<String> = mutableListOf("jewiru[oi","hpiuerh","qoieih","wuiehrf")
        val lsAlt1Mod: MutableList<String> = mutableListOf("jfhpisttuadh","hpiuerh","werwerro","woeihr","wiueghr")
        val item1: CreatorMediaEntity = CreatorMediaEntity(
            mediaId = 1,
            album = ls1,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "stronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt1,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        val itemCopy = item1.copy(
            mediaId = 1,
            album = ls1Mod,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "Astronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt1Mod,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        dao.insertMediaItem(item1)
        dao.updateCreator(itemCopy)
        val result = dao.getMedia().asLiveData().getOrAwaitValue()
        assertThat(result).doesNotContain(item1)
    }
    @Test
    fun deleteCreatorMedia() = runTest {
        val ls1: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh")
        val lsAlt1: MutableList<String> = mutableListOf("jfhpisttuadh","hpiuerh","werwerro")
        val ls2: MutableList<String> = mutableListOf("jfhpisuadh","hpiuerh","gse","erety")
        val lsAlt2: MutableList<String> = mutableListOf("jfhwerdh","hrwerrh","werwehro","weif")
        val item1: CreatorMediaEntity = CreatorMediaEntity(
            mediaId = 1,
            album = ls1,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "stronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt1,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        val item2: CreatorMediaEntity = CreatorMediaEntity(
            mediaId = 1,
            album = ls2,
            center = "GSFC",
            dateCreated = "2015-03-21T00:00:00Z",
            description = "stronomers using NASA’s Hubble Space Telescope ",
            description508 = "Soar through this cosmic landscape filled",
            keywords = lsAlt2,
            location = " Marshall Space Flight Center",
            mediaType = "image",
            nasaId = "hubble-observes-one-of-a-kind-star-nicknamed-nasty_17754652960_o",
            title = "TDD-OUT"
        )
        dao.insertMediaItem(item1)
        dao.insertMediaItem(item2)
        dao.deleteMediaItem(item1.mediaId)
        val result = dao.getMedia().asLiveData().getOrAwaitValue()
        assertThat(result).doesNotContain(item1)
    }

    @After
    fun teardown(){
        database.close()
    }
}