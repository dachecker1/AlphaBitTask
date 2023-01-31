package com.vk.alphabittask.di

import com.vk.alphabittask.presentation.view_models.TransactionEventsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { TransactionEventsViewModel(get()) }
}