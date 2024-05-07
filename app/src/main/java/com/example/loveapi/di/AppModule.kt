package com.example.loveapi.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loveapi.data.local.db.LoveDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    fun provideOnBoardPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("shared",Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): LoveDataBase =
        Room.databaseBuilder(context, LoveDataBase::class.java, "LoveDataBase").allowMainThreadQueries().build()
}