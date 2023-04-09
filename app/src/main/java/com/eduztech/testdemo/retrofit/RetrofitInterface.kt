package com.eduztech.testdemo.retrofit

import com.eduztech.testdemo.model.RandomUserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("api")
    fun getRandomUserData(@Query("results") s: String): Call<RandomUserModel>
}