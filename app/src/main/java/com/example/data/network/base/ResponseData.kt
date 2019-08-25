package com.example.data.network.base

import com.google.gson.annotations.SerializedName

data class ResponseData<T>(
    @SerializedName("type") val type: String,
    @SerializedName("value") val value: T
)