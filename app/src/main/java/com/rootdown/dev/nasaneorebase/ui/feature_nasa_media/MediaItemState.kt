package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot


data class MediaItemState(
    val media: MediaRoot,
    val name: String,
    val url: String
)