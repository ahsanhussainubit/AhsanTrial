package com.example.ahsantrial.data.entities

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Item(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName( "logo")
    var logo: String? = null,
    @SerializedName("image")
    var image: String? = null,
)
