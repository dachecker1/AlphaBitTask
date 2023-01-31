package com.vk.alphabittask.presentation.adapters

import android.util.SparseArray
import androidx.recyclerview.widget.DiffUtil
import com.vk.alphabittask.presentation.adapters.diffutils.ListItemModel

open class ListItemPagedDelegateAdapter constructor(
    typeToAdapterMap: SparseArray<IAdapterDelegate<BaseViewHolder<ListItemModel>, ListItemModel>>,
) : CompositePagedListAdapter<ListItemModel, BaseViewHolder<ListItemModel>>(
    diffItemCallback,
    typeToAdapterMap
) {
    class Builder :
        CompositePagedListAdapter.Builder<ListItemModel, BaseViewHolder<ListItemModel>, Builder>() {
        override fun build(): ListItemPagedDelegateAdapter {
            require(count != 0) { "Register at least one adapter" }
            return ListItemPagedDelegateAdapter(typeToAdapterMap)
        }
    }

    companion object {
        val diffItemCallback = object : DiffUtil.ItemCallback<ListItemModel>() {
            override fun areItemsTheSame(oldItem: ListItemModel, newItem: ListItemModel): Boolean {
                return oldItem.javaClass == newItem.javaClass && oldItem.identityEquality.equal(
                    oldItem,
                    newItem)
            }

            override fun areContentsTheSame(
                oldItem: ListItemModel,
                newItem: ListItemModel,
            ): Boolean {
                return oldItem.javaClass == newItem.javaClass && oldItem.contentEquality.equal(
                    oldItem,
                    newItem)
            }
        }
    }
}