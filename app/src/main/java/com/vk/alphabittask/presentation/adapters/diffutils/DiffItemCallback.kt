package com.vk.alphabittask.presentation.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.vk.alphabittask.domain.model.EqualityFunction

class DiffItemCallback<T> (
    var mIdentityEqualityFunction: EqualityFunction<in T>,
    var mContentEqualityFunction: EqualityFunction<in T>
) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return mIdentityEqualityFunction
            .equal(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return mContentEqualityFunction.equal(oldItem, newItem)
    }
}