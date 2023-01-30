package com.vk.alphabittask.data.repository

import com.vk.alphabittask.network.IRestApi
import com.vk.alphabittask.network.response.TransactionEvent

class TransactionRepository(
    private val mRestApi: IRestApi,
) {

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