package com.rootdown.dev.nasaneorebase.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rootdown.dev.nasaneorebase.data.net.MediaApiService
import com.rootdown.dev.nasaneorebase.data.net.NeoApiService
import com.rootdown.dev.nasaneorebase.di.util.RestfulServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    @Named("neoApi")
    fun provideRetrofitApi(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(RestfulServices.neo)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Singleton
    @Provides
    @Named("mediaApi")
    fun provideRetrofitAuth(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(RestfulServices.media)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun provideAuthApiService(@Named("neoApi") retrofit: Retrofit): NeoApiService = retrofit.create(
        NeoApiService::class.java)

    @Provides
    @Singleton
    fun provideApiService(@Named("mediaApi") retrofit: Retrofit): MediaApiService = retrofit.create(
        MediaApiService::class.java)
}