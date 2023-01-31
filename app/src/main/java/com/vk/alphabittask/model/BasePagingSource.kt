package com.vk.alphabittask.model

import androidx.paging.PagingSource
import androidx.paging.PagingState
import okio.IOException
import retrofit2.HttpException

private const val STARTING_PAGE_INDEX = 1

abstract class BasePagingSource<T : Any>(
    private val pageSize: Int,
) : PagingSource<Int, T>() {

    protected abstract suspend fun getItems(page: Int, requestLoaded: Int): List<T>

    @androidx.paging.ExperimentalPagingApi
    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        var position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = getItems(position, params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (response.size < params.loadSize) null else position + (params.loadSize / pageSize)
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}