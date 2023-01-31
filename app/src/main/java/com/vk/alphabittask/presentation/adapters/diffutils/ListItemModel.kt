package com.vk.alphabittask.presentation.adapters.diffutils

interface ListItemModel {
    val identityEquality: EqualityFunction<ListItemModel>
    val contentEquality: EqualityFunction<ListItemModel>
}