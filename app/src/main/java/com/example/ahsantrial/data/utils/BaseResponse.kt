package com.example.ahsantrial.data.utils

import com.google.gson.annotations.SerializedName


class BaseResponse<T> {
    @SerializedName( "success")
    val success: Boolean = false

    @SerializedName("message")
    val message: String? = null

    @SerializedName("data")
    val data: T? = null
}
