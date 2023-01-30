package com.vk.alphabittask.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vk.alphabittask.R
import com.vk.alphabittask.data.transaction.vo.TransactionItemVO
import com.vk.alphabittask.databinding.RvTransactionItemBinding
import com.vk.alphabittask.presentation.adapters.diffutils.TransactionEventsDiffUtil

class TransactionEventAdapter : ListAdapter<TransactionItemVO, TransactionEventAdapter.ViewHolder>(TransactionEventsDiffUtil()) {

    class ViewHolder(private val binding: RvTransactionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.transactionImage
        val transactionTitle = binding.transactionTitle
        val transactionReceiver = binding.transactionReceiver
        val transactionAmount = binding.transactionAmount
        val totalAmount = binding.totalAmount
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_transaction_item, parent, false)
        return ViewHolder(RvTransactionItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transactionItem = getItem(position)

        holder.image.setImageResource(R.drawable.ic_arrow_up)
        holder.transactionTitle.text = holder.itemView.context.getString(R.string.transaction_outcome)
        val totalAmount = StringBuilder()
        totalAmount
            .append("~ $ ")
            .append(transactionItem.value)
        holder.totalAmount.text = totalAmount.toString()
        val amountReceive = StringBuilder()
        if(true) { //TODO условие, по которому определять, входящий или исходящий платеж
            amountReceive.append("- ")
        } else {
            amountReceive.append("+ ")
        }
        amountReceive
            .append(transactionItem.value)
            .append(" ")
            .append(transactionItem.tokenSymbol)
        holder.transactionAmount.text = amountReceive.toString()
        val transactionReceiver = StringBuilder()
        if(true) {
            transactionReceiver
                .append(holder.itemView.context.getString(R.string.transaction_from))
                .append(transactionItem.from)
        } else {
            transactionReceiver
                .append(holder.itemView.context.getString(R.string.transaction_to))
                .append(transactionItem.to)
        }
        holder.transactionReceiver.text = transactionReceiver.toString()

    }
}