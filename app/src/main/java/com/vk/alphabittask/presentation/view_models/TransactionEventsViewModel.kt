package com.vk.alphabittask.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vk.alphabittask.domain.interactor.TransactionInteractor
import com.vk.alphabittask.domain.model.TransactionEventsDataSource
import com.vk.alphabittask.domain.model.ListItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class TransactionEventsViewModel(
    private val transactionInteractor: TransactionInteractor,
) : ViewModel() {

    lateinit var transactionDataSource: TransactionEventsDataSource

    val transactionEventsFlow: Flow<PagingData<ListItemModel>>
        get() = Pager(
            config = PagingConfig(
                TransactionEventsDataSource.PAGE_SIZE,
                enablePlaceholders = false,
                maxSize = 100
            ),
            pagingSourceFactory = {
                transactionDataSource = TransactionEventsDataSource(
                    transactionInteractor = transactionInteractor,
                    module = "account",
                    action = "tokentx",
                    address = "0xafC9796872cd604F0A4924fd958Fb638217bE289",
                    offset = 100,
                    sort = "desc"
                )
                transactionDataSource
            }
        )
            .flow
            .map {
                saveToBD(it)
                it
            }
            .catch { }
            .cachedIn(viewModelScope)

    private fun saveToBD(pagingData: PagingData<ListItemModel>) {

    }
}