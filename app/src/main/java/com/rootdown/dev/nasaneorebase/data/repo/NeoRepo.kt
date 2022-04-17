package com.rootdown.dev.nasaneorebase.data.repo

import com.rootdown.dev.nasaneorebase.data.model.remote.Feed

import com.rootdown.dev.nasaneorebase.domain.model.Resource

interface NeoRepo {
    suspend fun getNeo(): Resource<Feed>
}