package com.rootdown.dev.nasaneorebase.ui.feature_creator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import com.rootdown.dev.nasaneorebase.data.model.remote.MediaRoot
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.data.repo.CreatorRepoImpl
import com.rootdown.dev.nasaneorebase.lib.helpers.DefaultDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatorViewModel @Inject constructor(
    private val dispatchers: DefaultDispatchers,
    private val repo: CreatorRepoImpl
): ViewModel() {

    private val _uiState = MutableStateFlow(0)
    val uiState = _uiState.asStateFlow()
    //
    private val _sharedFlowNeo = MutableSharedFlow<Neo>(replay = 1)
    val sharedFlowNeo = _sharedFlowNeo.asSharedFlow()
    private val _sharedFlowMedia = MutableSharedFlow<MediaRoot.Collection.Item.Data>(replay = 1)
    val sharedFlowMedia = _sharedFlowMedia.asSharedFlow()
    var creatorMediaFlow: Flow<List<CreatorMediaEntity>>? = null
    var creatorNeoFlow: Flow<List<CreatorNeoEntity>>? = null

    init {
        viewModelScope.launch {
            creatorMediaFlow = repo.getCreatorMedia()
            creatorNeoFlow = repo.getCreatorNeo()
        }
    }
}

sealed class UiCreator{
    data class UiNeoCreator(val neo: CreatorNeoEntity): UiCreator()
    data class UiMediaCreator(val media: CreatorMediaEntity): UiCreator()
}