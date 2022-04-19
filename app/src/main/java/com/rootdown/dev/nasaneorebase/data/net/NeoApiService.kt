package com.rootdown.dev.nasaneorebase.data.net

import com.rootdown.dev.nasaneorebase.data.model.remote.NeoFeed
import retrofit2.Response
import retrofit2.http.GET

interface NeoApiService {
    @GET("neo/rest/v1/feed/today?detailed=true&api_key=cUsQuzCnvyTyHhyuaLJFLUjs9jRGJmAoogD9zWYH")
    suspend fun getNeo(): Response<NeoFeed>
}