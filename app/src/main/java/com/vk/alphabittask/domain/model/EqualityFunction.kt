package com.vk.alphabittask.domain.model

interface EqualityFunction<T> {
    fun equal(a: T, b: T): Boolean
}