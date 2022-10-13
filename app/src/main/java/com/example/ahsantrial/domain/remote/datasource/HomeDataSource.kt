package com.example.ahsantrial.domain.remote.datasource

import com.example.ahsantrial.domain.remote.apiservices.HomeApiServices
import javax.inject.Inject


class HomeDataSource @Inject constructor(private val homeApiServices: HomeApiServices) {

    suspend fun getHomeOne() = homeApiServices.getHomeOne()

    suspend fun getHomeTwo() = homeApiServices.getHomeTwo()

    suspend fun getHomeThree() = homeApiServices.getHomeThree()

}