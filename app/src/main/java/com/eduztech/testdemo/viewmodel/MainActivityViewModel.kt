package com.eduztech.testdemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eduztech.testdemo.model.RandomUserModel
import com.eduztech.testdemo.retrofit.RetroInstance
import com.eduztech.testdemo.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    var liveData: MutableLiveData<RandomUserModel> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<RandomUserModel>{
        return liveData
    }

    fun makeAPICall(count: String) {
        val retroInstance = RetroInstance.getRetrofitInstance()
        val retrofitService = retroInstance.create(RetrofitInterface::class.java)
        val call = retrofitService.getRandomUserData(count)

        call.enqueue(object : Callback<RandomUserModel>{
            override fun onResponse(call: Call<RandomUserModel>, response: Response<RandomUserModel>
            ) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<RandomUserModel>, t: Throwable) {
               liveData.postValue(null)
                Log.d("Failure Msg",""+t)
            }

        })
    }
}