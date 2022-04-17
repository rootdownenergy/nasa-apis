package com.rootdown.dev.nasaneorebase.data.repo

import com.rootdown.dev.nasaneorebase.data.model.remote.Feed
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.data.net.NeoApiService
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import java.lang.Exception
import javax.inject.Inject

class NeoRepoImpl @Inject constructor(
    private val api: NeoApiService
): NeoRepo {
    override suspend fun getNeo(): Resource<Feed> {
        return try {
            val response = api.getNeo()
            if(response.isSuccessful){
                response.body().let {
                    return@let Resource.success(it)
                }
            } else {
                Resource.error("Unknown Error", null)
            }
        } catch (e: Exception) {
            Resource.error("Network Unreachable", null)
        }
    }
}