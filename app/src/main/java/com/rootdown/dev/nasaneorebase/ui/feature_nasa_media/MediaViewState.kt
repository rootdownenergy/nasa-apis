package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import com.rootdown.dev.nasaneorebase.BR
import com.rootdown.dev.nasaneorebase.R
import me.tatarka.bindingcollectionadapter2.ItemBinding

data class MediaViewState(
    val items: List<MediaItemState>
) {
    fun getItemBinding(viewModel: MediaViewModel) =
        ItemBinding.of<MediaItemState>(BR.listItemState, R.layout.item_media)
            .bindExtra(BR.viewModel, viewModel)
}