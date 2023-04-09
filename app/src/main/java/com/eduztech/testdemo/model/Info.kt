package com.eduztech.testdemo.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
    @SerialName("page")
    val page: String,
    @SerialName("results")
    val results: String,
    @SerialName("seed")
    val seed: String,
    @SerialName("version")
    val version: String
)