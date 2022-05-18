package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rootdown.dev.nasaneorebase.data.model.remote.*
import com.rootdown.dev.nasaneorebase.data.repo.MediaRepo
import com.rootdown.dev.nasaneorebase.data.repo.MediaRepoImpl
import com.rootdown.dev.nasaneorebase.domain.model.Event
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediaViewModel @Inject constructor(
    private val repo: MediaRepo
) : ViewModel() {
    var count = 0
    var predaciteNum: Int = 0
    private val _result = MutableLiveData<Event<Resource<MediaRoot>>>()
    val result: LiveData<Event<Resource<MediaRoot>>> = _result

    private val _stateFlow = MutableStateFlow<Int>(0)
    val stateFlow = _stateFlow.asStateFlow()

    init {
        getResult()
    }
    private fun getResult() {
        _result.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = repo.searchMedia().data
            Log.w("###", response.toString())
            _result.value = Event(Resource.success(response))
        }
    }

    fun makeIds(i: Int){
        count++
        if(count<=i){makeIds(predaciteNum)}
    }
}
// Represents different states for neo screen
sealed class LatestMediaUiState {
    data class Success(val ms: String): LatestMediaUiState()
    data class Error(val e: Throwable): LatestMediaUiState()
}