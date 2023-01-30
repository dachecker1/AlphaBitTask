package com.vk.alphabittask.presentation.adapters.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.vk.alphabittask.data.TransactionItemVO

class TransactionEventsDiffUtil : DiffUtil.ItemCallback<TransactionItemVO>() {
    override fun areItemsTheSame(oldItem: TransactionItemVO, newItem: TransactionItemVO): Boolean {
        return oldItem.hash == newItem.hash
    }

    override fun areContentsTheSame(
        oldItem: TransactionItemVO,
        newItem: TransactionItemVO,
    ): Boolean {
        return oldItem.equals(newItem)
    }
}