package com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo

import com.rootdown.dev.nasaneorebase.R
import com.rootdown.dev.nasaneorebase.BR
import me.tatarka.bindingcollectionadapter2.ItemBinding

data class ListViewState(
    val items: List<NeoItemState>
) {
    fun getItemBinding(viewModel: NeoViewModel) =
        ItemBinding.of<NeoItemState>(BR.listItemState, R.layout.item_neo)
            .bindExtra(BR.viewModel, viewModel)
}