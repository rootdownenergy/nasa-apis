package com.rootdown.dev.nasaneorebase.util

import com.rootdown.dev.nasaneorebase.lib.helpers.DispatcherProviderHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher


@ExperimentalCoroutinesApi
class TestDispatchers: DispatcherProviderHelper {
    val testDispatcher = UnconfinedTestDispatcher()
    override val main: CoroutineDispatcher
        get() = testDispatcher
    override val io: CoroutineDispatcher
        get() = testDispatcher
    override val default: CoroutineDispatcher
        get() = testDispatcher
}