package com.vk.alphabittask.domain.interactor

import com.vk.alphabittask.data.repository.TransactionRepository
import com.vk.alphabittask.data.transaction.mapper.UserTransactionMapper
import com.vk.alphabittask.data.transaction.vo.TransactionItemVO

class TransactionInteractor(
    private val transactionRepository: TransactionRepository,
) {

    suspend fun getTransactionEvents(
        module: String,
        action: String,
        address: String,
        page: Int,
        offset: Int,
        sort: String,
    ): List<TransactionItemVO> {
        return transactionRepository.getTransactionEvents(
            module, action, address, page, offset, sort
        ).map { UserTransactionMapper.transform(it) }
    }
}