package com.rootdown.dev.nasaneorebase.data.source

import android.util.Log
import com.rootdown.dev.nasaneorebase.data.model.remote.MediaCollection
import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import com.rootdown.dev.nasaneorebase.data.repo.MediaRepo
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import java.io.IOError
import java.lang.Exception

class FakeMediaRepo : MediaRepo {
    val lsMod = mutableListOf<String>("testX","testY","testZ")
    val mediaItem = MediaRoot(collection = MediaRoot.Collection(
        href = "com.rootdown.engineering.dnssd",
        items = listOf(
            MediaRoot.Collection.Item(
                data = listOf(
                MediaRoot.Collection.Item.Data(
                album = listOf("album1","album2","album3"),
                center = "center",
                dateCreated = "DATE",
                description = "description",
                description508 = "description508",
                keywords = listOf("keyW1","keyW2"),
                location = "location",
                mediaType = "JPEG",
                nasaId = "idNasa1111",
                photographer = "youMindMap",
                secondaryCreator = "mapperMinds",
                title = "titles"),
                MediaRoot.Collection.Item.Data(
                    album = listOf("album11","album22","album33"),
                    center = "center4",
                    dateCreated = "DATE342",
                    description = "description3424",
                    description508 = "description5084234",
                    keywords = listOf("keyW14234","keyW2423"),
                    location = "location2342",
                    mediaType = "JPE4",
                    nasaId = "idNasa1111424",
                    photographer = "youMindMap4234",
                    secondaryCreator = "mapperMinds24314",
                    title = "titles")
            ),
                href = "com.rootdown.engineering.dnssd",
                links = listOf(
                    MediaRoot.Collection.Item.Link(
                        href = "com.rootdown.engineering.dnssd/testX",
                        rel = "self-htw",
                        render = ""
                    ),
                    MediaRoot.Collection.Item.Link(
                        href = "com.rootdown.engineering.dnssd/2",
                        rel = "self-htw2",
                        render = ""
                    )
                )
            )
        ),
        links = listOf(
            MediaRoot.Collection.Link(
                href = "test23123",
                prompt = "htw-1111",
                rel = "self-sandbox-cafe"
            )
        ),
        metadata = MediaRoot.Collection.Metadata(totalHits = 123603),
        version = "2-3986qhdf;")
    )

    override suspend fun searchMedia(): Resource<MediaRoot> {
        return try{
            Resource.success(mediaItem)
        } catch (e: Exception){
            Resource.error("unknown error",null)
        }
    }
}