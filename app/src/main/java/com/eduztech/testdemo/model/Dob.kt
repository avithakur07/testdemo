package com.eduztech.testdemo.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dob(
    @SerialName("age")
    val age: String,
    @SerialName("date")
    val date: String
)