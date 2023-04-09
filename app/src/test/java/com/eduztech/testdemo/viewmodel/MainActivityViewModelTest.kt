package com.eduztech.testdemo.viewmodel
import android.annotation.SuppressLint
import org.junit.After
import com.google.common.truth.Truth.*
import org.junit.Before
import org.junit.Test

class MainActivityViewModelTest {
    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
    mainActivityViewModel = MainActivityViewModel()
    }

    @SuppressLint("CheckResult")
    @Test
    fun get_RandomUserDatafromApiCall(){
        val result = mainActivityViewModel.makeAPICall("100")
        assertThat(result)
    }

    @After
    fun tearDown() {
    }
}