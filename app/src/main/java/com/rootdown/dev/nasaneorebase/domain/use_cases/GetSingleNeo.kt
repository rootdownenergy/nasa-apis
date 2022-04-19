package com.rootdown.dev.nasaneorebase.domain.use_cases

import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.data.repo.NeoRepoImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class GetSingleNeo @Inject constructor(
    private val repo: NeoRepoImpl
) {
    suspend fun getNeo() = repo.getNeo().data
}