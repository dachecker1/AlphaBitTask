package com.vk.alphabittask.presentation.adapters.diffutils

interface EqualityFunction<T> {
    fun equal(a: T, b: T): Boolean
}