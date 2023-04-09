package com.eduztech.testdemo

import com.eduztech.testdemo.retrofit.RetrofitInterface
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var retrofitInstance :RetrofitInterface

    @Before
    fun setup(){
        mockWebServer = MockWebServer();
        retrofitInstance = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)
    }
    @Test
    fun testGetRandomUserData()= runTest{
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = retrofitInstance.getRandomUserData("100")
        mockWebServer.takeRequest()

        Assert.assertEquals(true,response)
    }
    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}