package com.vk.alphabittask.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.vk.alphabittask.data.repository.TransactionRepository
import com.vk.alphabittask.domain.interactor.TransactionInteractor
import com.vk.alphabittask.domain.model.TransactionEventsDataSource
import com.vk.alphabittask.data.network.IRestApi
import com.vk.alphabittask.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createRetrofitClient().create(IRestApi::class.java) }
    single { getGson() }

    single { TransactionInteractor(get()) }
    single { TransactionRepository(get(), get(), get(named("IODispatcher"))) }
}

fun getGson(): Gson = GsonBuilder().setLenient().create()

fun createRetrofitClient() = retrofitClient()

private fun retrofitClient(
    baseUrl: String = Constants.URL.BASE_URL,
    httpClient: OkHttpClient = getInterceptorClient(),
): Retrofit =
    Retrofit.Builder().run {
        baseUrl(baseUrl)
        client(httpClient)
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(CoroutineCallAdapterFactory())
        build()
    }

private fun getInterceptorClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()
}