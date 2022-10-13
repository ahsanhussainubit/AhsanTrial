package com.example.ahsantrial.domain.remote.apiservices

import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.data.utils.BaseResponse
import com.example.ahsantrial.domain.remote.ApiConstants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiServices {

    @GET(ApiConstants.HOME_ONE_API)
    fun getHomeOne(): Call<BaseResponse<MutableList<HomeItem>>>

    @GET(ApiConstants.HOME_TWO_API)
    fun getHomeTwo(): Call<BaseResponse<MutableList<HomeItem>>>

    @GET(ApiConstants.HOME_THREE_API)
    fun getHomeThree(): Call<BaseResponse<MutableList<HomeItem>>>

}