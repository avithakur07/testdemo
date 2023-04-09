package com.eduztech.testdemo.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserModel(
    @SerialName("info")
    val info: Info,
    @SerialName("results")
    val results: List<Result>
)