package com.rootdown.dev.nasaneorebase.data.source

import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import com.rootdown.dev.nasaneorebase.data.repo.MediaRepo
import com.rootdown.dev.nasaneorebase.domain.model.Resource

class FakeMediaRepo : MediaRepo {
    override suspend fun searchMedia(): Resource<MediaRoot> {
        TODO("Not yet implemented")
    }
}