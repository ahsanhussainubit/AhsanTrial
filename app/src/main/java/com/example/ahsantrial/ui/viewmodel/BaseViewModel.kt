package com.example.ahsantrial.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.ahsantrial.AhsanTrialApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
) : ViewModel() {

    val loaderVisible = MutableSharedFlow<Boolean>()

//    val error = MutableSharedFlow<ErrorModel>()

    fun errorHandle(error: Throwable) {

    }

    fun noInternetConnection() {
//        Toast.makeText(appContext, "No Internet Connection", Toast.LENGTH_SHORT).show()
    }

}