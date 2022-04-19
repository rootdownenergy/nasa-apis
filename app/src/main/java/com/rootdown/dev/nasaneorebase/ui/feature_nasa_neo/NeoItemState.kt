package com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo

import com.rootdown.dev.nasaneorebase.data.model.remote.Neo

data class NeoItemState(
    val neo: Neo,
    val name: String,
    val url: String
)