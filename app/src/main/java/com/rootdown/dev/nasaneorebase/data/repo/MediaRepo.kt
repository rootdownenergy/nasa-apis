package com.rootdown.dev.nasaneorebase.data.repo

import com.rootdown.dev.nasaneorebase.data.model.remote.MediaCollection
import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import com.rootdown.dev.nasaneorebase.domain.model.Resource

interface MediaRepo {
    suspend fun searchMedia(): Resource<MediaRoot>
}