package com.vk.alphabittask.presentation.adapters

import android.util.SparseArray
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.vk.alphabittask.presentation.adapters.diffutils.DiffItemCallback

open class CompositePagedListAdapter<T: Any, VH : BaseViewHolder<T>>
protected constructor(
    diffItemCallback : DiffUtil.ItemCallback<T>,
    val typeToAdapterMap : SparseArray<IAdapterDelegate<VH, T>>
) : PagingDataAdapter<T, VH>(diffItemCallback) {

    //TODO возможно потребуется переопределить этот метод
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val delegateAdapter : IAdapterDelegate<VH, T>? = typeToAdapterMap[getItemViewType(position)]
        getItem(position)?.let {
            delegateAdapter?.onBindViewHolder(holder, it)
                ?: throw NullPointerException("can not find adapter for position $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return typeToAdapterMap[viewType]
            .onCreateViewHolder(parent, viewType)
    }

    open class Builder<T: Any, VH : BaseViewHolder<T>, B: Builder<T, VH, B>>() {
        protected var count = 0
        protected val typeToAdapterMap = SparseArray<IAdapterDelegate<VH, T>>()
        protected var diffItemCallback : DiffItemCallback<T>? = null
        fun add(delegateAdapter : IAdapterDelegate<VH, T>) : B {
            typeToAdapterMap.put(count++, delegateAdapter)
            return this as B
        }

        fun diffItem(diffItemCallback : DiffItemCallback<T>) :B {
            this.diffItemCallback = diffItemCallback
            return this as B
        }

        open fun build() : CompositePagedListAdapter<T,VH> {
            require( count != 0) { "Register at least one adapter" }
            requireNotNull(diffItemCallback) { "Need DiffItemCallback" }
            return CompositePagedListAdapter(diffItemCallback!!, typeToAdapterMap)
        }
    }
}
