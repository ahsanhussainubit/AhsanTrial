package com.example.ahsantrial.domain.repository

import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.data.utils.Resource


interface HomeRepository {

    suspend fun getHomeOne(): Resource<MutableList<HomeItem>>

    suspend fun getHomeTwo(): Resource<MutableList<HomeItem>>

    suspend fun getHomeThree(): Resource<MutableList<HomeItem>>

}