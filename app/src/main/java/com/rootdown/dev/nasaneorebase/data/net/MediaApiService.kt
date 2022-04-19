package com.rootdown.dev.nasaneorebase.data.net


import com.rootdown.dev.nasaneorebase.data.model.remote.MediaFeed
import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import retrofit2.Response
import retrofit2.http.GET

interface MediaApiService {
    @GET("search?q=stars")
    suspend fun getMedia(): Response<MediaRoot>
}