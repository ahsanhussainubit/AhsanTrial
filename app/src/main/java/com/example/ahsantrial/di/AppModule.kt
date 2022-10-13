package com.example.ahsantrial.di

import com.example.ahsantrial.AhsanTrialApplication
import com.example.ahsantrial.domain.remote.apiservices.HomeApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAhsanTrialApplication(): AhsanTrialApplication {
        return AhsanTrialApplication()
    }

    @Provides
    fun provideHomeApiServices(retrofit: Retrofit): HomeApiServices {
        return retrofit
            .create(HomeApiServices::class.java)
    }

}