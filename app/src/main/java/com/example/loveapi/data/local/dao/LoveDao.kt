package com.example.loveapi.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.loveapi.data.local.entity.HistoryEntity

@Dao
interface LoveDao {

    @Insert
    fun addHistory (historyEntity: HistoryEntity)

    @Query("SELECT * FROM histories")
    fun getHistory(): List<HistoryEntity>

    @Delete
    fun deleteHistory(historyEntity: HistoryEntity)
}