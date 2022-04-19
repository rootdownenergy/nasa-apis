package com.rootdown.dev.nasaneorebase.domain.use_cases

import com.rootdown.dev.nasaneorebase.data.repo.MediaRepoImpl
import javax.inject.Inject

class GetSingleMedia @Inject constructor(
    private val repo: MediaRepoImpl
){
    suspend fun getMedia() = repo.searchMedia().data
}