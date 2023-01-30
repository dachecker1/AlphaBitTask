package com.vk.alphabittask.network

import com.vk.alphabittask.network.response.TransactionListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IRestApi {

    @GET("api")
    suspend fun getTransactionList(
        @Query("module") module: String,
        @Query("action") action: String,
        @Query("address") address: String,
        @Query("page") page: Int,
        @Query("offset") offset: Int,
        @Query("sort") sort: String,
    ): TransactionListResponse
}