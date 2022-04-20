package com.rootdown.dev.nasaneorebase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rootdown.dev.nasaneorebase.data.local.dao.CreatorMediaDao
import com.rootdown.dev.nasaneorebase.data.local.dao.CreatorNeoDao
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorMediaEntity
import com.rootdown.dev.nasaneorebase.data.local.entities.CreatorNeoEntity
import com.rootdown.dev.nasaneorebase.lib.helpers.ListStringConverter

@Database(
    entities = [CreatorMediaEntity::class,CreatorNeoEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun creatorNeoDao(): CreatorNeoDao
    abstract fun creatorMediaDao(): CreatorMediaDao
}