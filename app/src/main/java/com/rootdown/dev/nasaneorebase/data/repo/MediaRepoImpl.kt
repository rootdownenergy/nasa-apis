package com.rootdown.dev.nasaneorebase.data.repo

import com.rootdown.dev.nasaneorebase.data.model.remote.Media
import com.rootdown.dev.nasaneorebase.data.net.MediaApiService
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import java.lang.Exception
import javax.inject.Inject

class MediaRepoImpl @Inject constructor(
    private val api: MediaApiService
): MediaRepo {
    override suspend fun searchMedia(): Resource<Media> {
        return try {
            val response = api.getMedia()
            if(response.isSuccessful){
                response.body().let {
                    return@let Resource.success(it)
                }
            } else {
                Resource.error("Unknown Error", null)
            }
        } catch (e: Exception) {
            Resource.error("Network Unreachable",null)
        }
    }
}