package com.vk.alphabittask.presentation.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.vk.alphabittask.R
import com.vk.alphabittask.data.transaction.vo.TransactionItemVO

class TransactionEventAdapter :
    BaseAdapterDelegate<TransactionEventAdapter.TransactionViewHolder, TransactionItemVO>() {

    override val layoutId: Int
        get() = R.layout.rv_transaction_item

    class TransactionViewHolder(itemView: View) :
        BaseViewHolder<TransactionItemVO>(itemView) {
        override fun bindTo(item: TransactionItemVO) {
            val image = itemView.findViewById<ImageView>(R.id.transaction_image)
            val transactionTitle = itemView.findViewById<TextView>(R.id.transaction_title)
            val transactionReceiver = itemView.findViewById<TextView>(R.id.transaction_receiver)
            val transactionAmount = itemView.findViewById<TextView>(R.id.transaction_amount)
            val totalAmount = itemView.findViewById<TextView>(R.id.total_amount)

            image.setImageResource(R.drawable.ic_arrow_up)
            transactionTitle.text = itemView.context.getString(R.string.transaction_outcome)
            val totalAmountText = StringBuilder()
            totalAmountText
                .append("~ $ ")
                .append(item.value)
            totalAmount.text = totalAmountText.toString()
            val amountReceive = StringBuilder()
            if (true) { //TODO условие, по которому определять, входящий или исходящий платеж
                amountReceive.append("- ")
            } else {
                amountReceive.append("+ ")
            }
            amountReceive
                .append(item.value)
                .append(" ")
                .append(item.tokenSymbol)
            transactionAmount.text = amountReceive.toString()
            val transactionReceiverText = StringBuilder()
            if (true) {
                transactionReceiverText
                    .append(itemView.context.getString(R.string.transaction_from))
                    .append(item.from)
            } else {
                transactionReceiverText
                    .append(itemView.context.getString(R.string.transaction_to))
                    .append(item.to)
            }
            transactionReceiver.text = transactionReceiverText.toString()
        }
    }

    override fun onRecycled(holder: TransactionViewHolder) {}

    override fun createViewHolder(parent: View): TransactionViewHolder {
        return TransactionViewHolder(parent)
    }

    override fun isForViewType(item: Any): Boolean {
        return item is TransactionItemVO
    }
}