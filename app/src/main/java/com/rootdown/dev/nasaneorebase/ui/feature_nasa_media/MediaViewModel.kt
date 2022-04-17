package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rootdown.dev.nasaneorebase.data.model.remote.Media
import com.rootdown.dev.nasaneorebase.data.repo.MediaRepoImpl
import com.rootdown.dev.nasaneorebase.domain.model.Event
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediaViewModel @Inject constructor(
    private val repo: MediaRepoImpl
) : ViewModel() {
    var count = 0
    var predaciteNum: Int = 0
    private val _result = MutableLiveData<Event<Resource<Media>>>()
    val result: LiveData<Event<Resource<Media>>> = _result
    init {
        getResult()
    }
    private fun getResult(){
        _result.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = repo.searchMedia()
            Log.w("NET", response.toString())
            _result.value = Event(response)
        }
    }
    fun makeIds(i: Int){
        count++
        if(count<=i){makeIds(predaciteNum)}
    }
}