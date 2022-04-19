package com.rootdown.dev.nasaneorebase.data.repo

import android.util.Log
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.data.model.remote.NeoFeed
import com.rootdown.dev.nasaneorebase.data.net.NeoApiService
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

class NeoRepoImpl @Inject constructor(
    private val api: NeoApiService
): NeoRepo {
    override suspend fun getNeo(): Resource<List<Neo>> {
         return try {
            val response = api.getNeo()
             Log.w("NET!", response.body().toString())
            if(response.isSuccessful){
                response.body().let {
                    val xi = it?.nearEarthObjects?.get("2022-04-19")
                    Log.w("TAG", xi.toString())
                    Log.w("TAG", xi?.first().toString())
                    Resource.success(xi)
                }
            } else {
                Resource.error("Unknown Error", null)
            }
        } catch (e: Exception) {
             Resource.error("Network Unreachable",null)
        }
    }
}