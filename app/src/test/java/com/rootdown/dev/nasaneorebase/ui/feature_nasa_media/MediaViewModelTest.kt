package com.rootdown.dev.nasaneorebase.ui.feature_nasa_media

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.rootdown.dev.nasaneorebase.data.net.MediaApiService
import com.rootdown.dev.nasaneorebase.data.source.FakeMediaRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Config(sdk = [29])
@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class MediaViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var server: MockWebServer
    //sut
    private lateinit var service: MediaApiService
    private var eMsg = "error the current acromine data item not found"
    private var flagger = false

    private var shouldReturnNetworkError = false

    fun shouldReturnNetError(value: Boolean){
        shouldReturnNetworkError = value
    }

    //sut
    lateinit var vm: MediaViewModel
    //fake
    lateinit var fakeRepo: FakeMediaRepo

    @Before
    fun setup(){
        fakeRepo = FakeMediaRepo()
        vm = MediaViewModel(fakeRepo)
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MediaApiService::class.java)
    }

    @Test
    fun `response is not empty`() = runBlocking {
        mockResponse("success_response_media.json")
        val responseBody = service.getMedia().body()
        //Request received by the mock server
        val request = server.takeRequest()
        assertThat(responseBody).isNotNull()
        assertThat(request.path).isEqualTo("/search?q=stars")
    }



    private fun mockResponse(fileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            server.enqueue(mockResponse)
        }
    }
}