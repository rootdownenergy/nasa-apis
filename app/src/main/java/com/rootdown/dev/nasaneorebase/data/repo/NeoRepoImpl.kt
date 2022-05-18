package com.rootdown.dev.nasaneorebase.data.repo

import android.util.Log
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.data.net.NeoApiService
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class NeoRepoImpl @Inject constructor(
    private val api: NeoApiService
): NeoRepo {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val xOutTime = current.format(formatter)
    var nowInParis: ZonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"))
    val timex = nowInParis.toOffsetDateTime()
    val xix = timex.toLocalDate()

    val job = SupervisorJob()


    override suspend fun getNeo(): Resource<List<Neo>> {
         return try {
            val response = api.getNeo()
             Log.w("NET!", response.body().toString())
             Log.w("NET!", xix.toString())
            if(response.isSuccessful){
                response.body().let {
                    val xi = it?.nearEarthObjects?.get(xix.toString())
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