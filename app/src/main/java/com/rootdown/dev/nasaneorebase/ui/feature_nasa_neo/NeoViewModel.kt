package com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rootdown.dev.nasaneorebase.data.model.remote.Neo
import com.rootdown.dev.nasaneorebase.data.model.remote.NeoFeed
import com.rootdown.dev.nasaneorebase.data.repo.NeoRepoImpl
import com.rootdown.dev.nasaneorebase.domain.model.Event
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import com.rootdown.dev.nasaneorebase.domain.use_cases.GetSingleNeo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NeoViewModel @Inject constructor(
    private val repo: NeoRepoImpl
) : ViewModel() {

    var count = 0
    var predaciteNum: Int = 0

    private val _itemToOpen = MutableLiveData<Event<NeoItemState>>()
    val itemToOpen: LiveData<Event<NeoItemState>> = _itemToOpen
    val viewState = MutableLiveData<ListViewState>()
    private val _uiState = MutableStateFlow(1)
    val uiState = _uiState.asStateFlow()
    //
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()
    private val _result = MutableLiveData<Event<Resource<List<Neo>>>>()
    val result: LiveData<Event<Resource<List<Neo>>>> = _result
    init {
        getResult()
    }

    private fun getResult(){
        _result.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = repo.getNeo().data
            Log.w("###", response.toString())
            _result.value = Event(Resource.success(response))
        }
    }
    fun makeIds(i: Int){
        count++
        if(count<=i){makeIds(predaciteNum)}
    }
    fun onItemClicked(itemState: NeoItemState) {
        _itemToOpen.postValue(Event(itemState))
    }
}
// Represents different states for neo screen
sealed class LatestNeoUiState {
    data class Success(val msg: String): LatestNeoUiState()
    data class Error(val e: Throwable): LatestNeoUiState()
}