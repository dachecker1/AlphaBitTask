package com.vk.alphabittask.data.data_base

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vk.alphabittask.data.data_base.entity.ItemTransactionDbModel

@Database(entities = [ItemTransactionDbModel::class], version = 1, exportSchema = false)
abstract class TransactionsDataBase : RoomDatabase() {

    abstract fun transactionListDao(): TransactionListDao

    companion object {
        private var INSTANCE: TransactionsDataBase? = null
        private const val DB_NAME = "transactionList.db"

        fun getInstance(application: Application): TransactionsDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    TransactionsDataBase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}