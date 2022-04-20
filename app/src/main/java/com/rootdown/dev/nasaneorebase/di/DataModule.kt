package com.rootdown.dev.nasaneorebase.di

import android.content.Context
import androidx.room.Room
import com.rootdown.dev.nasaneorebase.data.local.AppDatabase
import com.rootdown.dev.nasaneorebase.data.local.dao.CreatorMediaDao
import com.rootdown.dev.nasaneorebase.data.local.dao.CreatorNeoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCreatorNeoDao(appDatabase: AppDatabase): CreatorNeoDao {
        return appDatabase.creatorNeoDao()
    }

    @Provides
    @Singleton
    fun provideCreatorMediaDao(appDatabase: AppDatabase): CreatorMediaDao {
        return appDatabase.creatorMediaDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "nasa"
        ).build()
    }
}