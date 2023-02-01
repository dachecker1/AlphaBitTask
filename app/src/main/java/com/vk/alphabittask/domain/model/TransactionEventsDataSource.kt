package com.vk.alphabittask.domain.model

import com.vk.alphabittask.data.data_base.TransactionsDataBase
import com.vk.alphabittask.domain.interactor.TransactionInteractor

private const val STARTING_PAGE_INDEX = 1

class TransactionEventsDataSource(
    private val transactionInteractor: TransactionInteractor,
    private val module: String = "",
    private val action: String = "",
    private val address: String = "",
    private val offset: Int = 0,
    private val sort: String = "",
) : BasePagingSource<ListItemModel>(PAGE_SIZE) {

    override suspend fun getItems(page: Int, requestLoaded: Int): List<ListItemModel> {
        if(true) {
            //проверить локальную базу. если в базе есть эта страница, то сетевой запрос не выполняем
        } else {
            // вызываем transactionInteractor.getTransactionEvents()
        }
        val list: MutableList<ListItemModel> = transactionInteractor.getTransactionEvents(
            module = module,
            action = action,
            address = address,
            page = page,
            offset = offset,
            sort = sort
        ).toMutableList()
        return list
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}