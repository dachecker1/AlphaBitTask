package com.vk.alphabittask.domain.model

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

        var list: MutableList<ListItemModel> = transactionInteractor.getTransactionEventsFromDB(
            page,
            offset
        ).toMutableList()
        //TODO фиксануть БД, понаписал туда дублей
        //TODO чтение из БД идет некорректное, возвращается только первый элемент. Разобраться почему
        if (list.isEmpty()) {
            list = transactionInteractor.getTransactionEvents(
                module = module,
                action = action,
                address = address,
                page = page,
                offset = offset,
                sort = sort
            ).toMutableList()
            transactionInteractor.insertDataToDB(list.toList())
        }
        return list
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}