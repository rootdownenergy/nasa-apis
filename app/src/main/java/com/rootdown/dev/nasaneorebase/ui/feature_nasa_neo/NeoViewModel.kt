package com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rootdown.dev.nasaneorebase.data.model.remote.Feed
import com.rootdown.dev.nasaneorebase.data.repo.NeoRepoImpl
import com.rootdown.dev.nasaneorebase.domain.model.Event
import com.rootdown.dev.nasaneorebase.domain.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NeoViewModel @Inject constructor(
    private val repo: NeoRepoImpl
) : ViewModel() {
    var count = 0
    var predaciteNum: Int = 0
    private val _result = MutableLiveData<Event<Resource<Feed>>>()
    val result: LiveData<Event<Resource<Feed>>> = _result
    init {
        getResult()
    }
    private fun getResult(){
        _result.value = Event(Resource.loading(null))
        viewModelScope.launch {
            val response = repo.getNeo()
            Log.w("NET", response.toString())
            _result.value = Event(response)
        }
    }
    fun makeIds(i: Int){
        count++
        if(count<=i){makeIds(predaciteNum)}
    }
}