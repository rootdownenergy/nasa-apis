package com.rootdown.dev.nasaneorebase.ui.feature_nasa_neo

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.rootdown.dev.nasaneorebase.ui.feature_creator.CreatorViewModel
import com.rootdown.dev.nasaneorebase.util.TestDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CreatorViewModelTest() {

    /*
    * @var object under test (OUT)
    */
    private lateinit var vm: CreatorViewModel
    private lateinit var testDispatchers: TestDispatchers

    @Before
    fun setup(){
        testDispatchers = TestDispatchers()
        vm = CreatorViewModel(testDispatchers)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `countDownFlow, properly counts down from 5 to 0`() = runBlocking {
        // suspend block until get item
        vm.countDownFlow.test {
            //wait for emission
            for(i in 5 downTo 0) {
                testDispatchers.testDispatcher.scheduler.advanceTimeBy(1000L)
                val emission = awaitItem()
                assertThat(emission).isEqualTo(i)
            }
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `squareNumber, number properly squared`() = runBlocking {
        val job = launch {
            vm.sharedFlow.test {
                val emission = awaitItem()
                assertThat(emission).isEqualTo(9)
                cancelAndConsumeRemainingEvents()
            }
        }
        vm.squareNum(3)
        job.join()
        job.cancel()
    }

}