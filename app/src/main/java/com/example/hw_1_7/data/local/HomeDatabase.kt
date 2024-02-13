package com.example.hw_1_7.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CameraData::class, DoorData::class], version = 2)
abstract class HomeDatabase:RoomDatabase() {
    abstract fun homeDao():HomeDao
}