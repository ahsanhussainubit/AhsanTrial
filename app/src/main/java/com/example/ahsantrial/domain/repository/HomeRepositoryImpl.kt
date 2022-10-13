package com.example.ahsantrial.domain.repository

import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.data.utils.Resource
import com.example.ahsantrial.domain.remote.datasource.HomeDataSource
import retrofit2.awaitResponse
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override suspend fun getHomeOne(): Resource<MutableList<HomeItem>> {
        /* return try {
             val response = homeDataSource.getHome()
             Resource.success(data = response.body() ?: mutableListOf())
         }*/
        val response = homeDataSource.getHomeOne()
        return Resource.success(data = response.awaitResponse().body()?.data ?: mutableListOf())
    }

    override suspend fun getHomeTwo(): Resource<MutableList<HomeItem>> {
        val response = homeDataSource.getHomeTwo()
        return Resource.success(data = response.awaitResponse().body()?.data ?: mutableListOf())
    }

    override suspend fun getHomeThree(): Resource<MutableList<HomeItem>> {
        val response = homeDataSource.getHomeThree()
        return Resource.success(data = response.awaitResponse().body()?.data ?: mutableListOf())
    }

}

