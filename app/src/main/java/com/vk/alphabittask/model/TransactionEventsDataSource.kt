package com.vk.alphabittask.model

import com.vk.alphabittask.data.transaction.vo.TransactionItemVO
import com.vk.alphabittask.domain.interactor.TransactionInteractor

private const val STARTING_PAGE_INDEX = 1

class TransactionEventsDataSource(
    private val transactionInteractor : TransactionInteractor,
    private val module : String = "",
    private val action : String = "",
    private val address : String = "",
    private val offset : Int = 0,
    private val sort : String = ""
) : BasePagingSource<TransactionItemVO>(PAGE_SIZE){

    override suspend fun getItems(page: Int, requestLoaded: Int): List<TransactionItemVO> {
        val list : MutableList<TransactionItemVO> = transactionInteractor.getTransactionEvents(
            module = module,
            action = action,
            address = address,
            page = page,
            offset = offset,
            sort = sort
        ).toMutableList()
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}