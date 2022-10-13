package com.example.ahsantrial.data.entities

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class HomeItem(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("is_see_all_shown")
    val isSeeAllShown: Boolean = false,
    @SerializedName( "type")
    val type: String,
    @SerializedName("background_color")
    val backgroundColor: String? = "#FFFFFF",
    @SerializedName("items")
    val items: Any,
)
