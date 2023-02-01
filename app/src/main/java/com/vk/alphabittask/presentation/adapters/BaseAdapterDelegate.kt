package com.vk.alphabittask.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.vk.alphabittask.domain.model.IAdapterDelegate

abstract class BaseAdapterDelegate<VH : BaseViewHolder<T>, T> : IAdapterDelegate<VH, T> {

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract fun createViewHolder(parent: View): VH

    override fun onRecycled(holder: VH) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflatedView = LayoutInflater.from(parent.context).inflate(
            layoutId, parent, false
        )
        return createViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: VH, item: T) {
        holder.bindTo(item)
    }
}