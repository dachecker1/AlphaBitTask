package com.vk.alphabittask.data.data_base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vk.alphabittask.data.data_base.entity.ItemTransactionDbModel

@Dao
interface TransactionListDao {

    @Query("SELECT * FROM transactionList")
    fun getTransactionListLiveData() : List<ItemTransactionDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTransactionList(list : List<ItemTransactionDbModel>)
}