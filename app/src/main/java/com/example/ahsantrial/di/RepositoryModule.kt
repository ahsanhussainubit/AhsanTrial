package com.example.ahsantrial.di

import com.example.ahsantrial.domain.remote.datasource.HomeDataSource
import com.example.ahsantrial.domain.repository.HomeRepository
import com.example.ahsantrial.domain.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideHomeRepository(homeDataSource: HomeDataSource): HomeRepository {
        return HomeRepositoryImpl(homeDataSource)
    }

}