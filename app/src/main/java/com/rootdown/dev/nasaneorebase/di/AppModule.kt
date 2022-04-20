package com.rootdown.dev.nasaneorebase.di

import com.rootdown.dev.nasaneorebase.data.net.MediaApiService
import com.rootdown.dev.nasaneorebase.data.net.NeoApiService
import com.rootdown.dev.nasaneorebase.data.repo.MediaRepo
import com.rootdown.dev.nasaneorebase.data.repo.MediaRepoImpl
import com.rootdown.dev.nasaneorebase.data.repo.NeoRepo
import com.rootdown.dev.nasaneorebase.data.repo.NeoRepoImpl
import com.rootdown.dev.nasaneorebase.lib.helpers.DefaultDispatchers
import com.rootdown.dev.nasaneorebase.lib.helpers.DispatcherProviderHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMediaRepoImpl(
        service: MediaApiService
    ) = MediaRepoImpl(service) as MediaRepo

    @Provides
    @Singleton
    fun provideNeoRepoImpl(
        service: NeoApiService
    ) = NeoRepoImpl(service) as NeoRepo

    @Provides
    @Singleton
    fun provideDefaultDispatcher(): DefaultDispatchers {
        return DefaultDispatchers()
    }



}