package com.example.testbaseonline.di

import com.example.testbaseonline.data.RealRemoteRepository
import com.example.testbaseonline.data.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindRemoteRepository(repository: RealRemoteRepository): RemoteRepository
}