package com.vk.alphabittask.data.repository

import android.app.Application
import com.vk.alphabittask.data.data_base.TransactionsDataBase
import com.vk.alphabittask.data.network.IRestApi
import com.vk.alphabittask.data.network.response.TransactionEvent

class TransactionRepository(
    private val mRestApi: IRestApi,
    private val application : Application
) {

    private val transactionListDao by lazy {
        TransactionsDataBase.getInstance(application).transactionListDao()
    }

    suspend fun getTransactionEvents(
        module: String,
        action: String,
        address: String,
        page: Int,
        offset: Int,
        sort: String,
    ): List<TransactionEvent> {
        return mRestApi.getTransactionList(
            module, action, address, page, offset, sort
        )
            .transactions
    }
}