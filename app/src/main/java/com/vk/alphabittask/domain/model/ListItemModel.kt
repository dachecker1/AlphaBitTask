package com.vk.alphabittask.domain.model

interface ListItemModel {
    val identityEquality: EqualityFunction<ListItemModel>
    val contentEquality: EqualityFunction<ListItemModel>
}