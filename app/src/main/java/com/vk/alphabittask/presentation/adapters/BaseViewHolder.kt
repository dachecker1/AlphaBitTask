package com.vk.alphabittask.presentation.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<D>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun bindTo(item : D) {

    }
}