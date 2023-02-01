package com.vk.alphabittask.domain.model

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface IAdapterDelegate<VH: RecyclerView.ViewHolder, T> {
    fun onCreateViewHolder(parent: ViewGroup, viewType : Int) : VH

    fun onBindViewHolder(holder : VH, item : T)

    fun onRecycled(holder : VH)

    fun isForViewType(item: Any): Boolean
}