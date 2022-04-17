package com.rootdown.dev.nasaneorebase.domain.model

open class Event<out T>(private val itX: T){
    var handled = false
        private set
    fun notHandled(): T?{
        return if (handled){
            null
        } else {
            handled = true
            itX
        }
    }
    fun getIt(): T = itX
}