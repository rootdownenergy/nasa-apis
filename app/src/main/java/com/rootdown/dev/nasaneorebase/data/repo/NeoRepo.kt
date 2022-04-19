package com.rootdown.dev.nasaneorebase.data.repo

import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface NeoRepo {
    suspend fun getNeo(): Resource<List<Neo>>
}