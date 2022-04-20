package com.rootdown.dev.nasaneorebase.ui.feature_creator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rootdown.dev.nasaneorebase.lib.helpers.DispatcherProviderHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class CreatorViewModel (
    private val dispatchers: DispatcherProviderHelper
): ViewModel() {
    val countDownFlow = flow<Int> {
        val startingValue = 5
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {
            delay(1111L)
            currentValue --
            emit(currentValue)
        }
    }.flowOn(dispatchers.main)
    private val _uiState = MutableStateFlow(0)
    val uiState = _uiState.asStateFlow()
    //
    private val _sharedFlow = MutableSharedFlow<Int>(replay = 5)
    val sharedFlow = _sharedFlow.asSharedFlow()
    init {
        viewModelScope.launch(dispatchers.main) {
            sharedFlow.collect {
                delay(2000L)
                println("First Flow: the received nunm is: $it")
            }
        }
        viewModelScope.launch(dispatchers.main)  {
            sharedFlow.collect {
                delay(3000L)
                println("the received nunm is: $it")
            }
        }
        // this is the event we are sending into the shared flow
        squareNum(3)
    }
    fun squareNum(num: Int){
        // suspends coroutine as long as all the collectors of the shared flow need to process it
        viewModelScope.launch(dispatchers.main)  {
            _sharedFlow.emit(num * num)
        }
    }
    fun incrementCounter() {
        _uiState.value += 1
    }

}