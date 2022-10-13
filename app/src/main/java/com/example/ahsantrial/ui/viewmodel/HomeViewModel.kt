package com.example.ahsantrial.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.ahsantrial.data.entities.HomeItem
import com.example.ahsantrial.data.utils.Resource
import com.example.ahsantrial.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val networkHelper: NetworkHelper,
    private val homeRepository: HomeRepository
) : BaseViewModel() {

    val homeList = MutableSharedFlow<MutableList<HomeItem>>()

    fun getHomeOne() {
//        if (networkHelper.isNetworkAvailable()) {
            viewModelScope.launch {
                loaderVisible.emit(true)
                val response = homeRepository.getHomeOne()
                when (response.status) {
                    Resource.STATUS.SUCCESS -> {
                        loaderVisible.emit(false)
                        response.data?.let {
                            homeList.emit(it)
                        }
                    }
                    Resource.STATUS.ERROR -> {
                        loaderVisible.emit(false)
                        response.error?.let {
                            errorHandle(it)
                        }
                    }
                }
            }
//        } else {
//            noInternetConnection()
//        }
    }

    fun getHomeTwo() {
        viewModelScope.launch {
            loaderVisible.emit(true)
            val response = homeRepository.getHomeTwo()
            when (response.status) {
                Resource.STATUS.SUCCESS -> {
                    loaderVisible.emit(false)
                    response.data?.let {
                        homeList.emit(it)
                    }
                }
                Resource.STATUS.ERROR -> {
                    loaderVisible.emit(false)
                    response.error?.let {
//                        errorHandle(it)
                    }
                }
            }
        }
    }

    fun getHomeThree() {
        viewModelScope.launch {
            loaderVisible.emit(true)
            val response = homeRepository.getHomeThree()
            when (response.status) {
                Resource.STATUS.SUCCESS -> {
                    loaderVisible.emit(false)
                    response.data?.let {
                        homeList.emit(it)
                    }
                }
                Resource.STATUS.ERROR -> {
                    loaderVisible.emit(false)
                    response.error?.let {
//                        errorHandle(it)
                    }
                }
            }
        }
    }

}