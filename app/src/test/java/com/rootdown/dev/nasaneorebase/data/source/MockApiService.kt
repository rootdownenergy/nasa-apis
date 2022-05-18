package com.rootdown.dev.nasaneorebase.data.source

import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import com.rootdown.dev.nasaneorebase.data.net.MediaApiService
import retrofit2.Response


class MockApiService : MediaApiService {
    val source = FakeMediaRepo()



    override suspend fun getMedia(): Response<MediaRoot> {
        TODO()
    }

    companion object {

    }

}