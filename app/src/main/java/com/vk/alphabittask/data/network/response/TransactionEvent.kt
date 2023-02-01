package com.vk.alphabittask.data.network.response

import com.google.gson.annotations.SerializedName
import com.vk.alphabittask.domain.transaction_event.ITransactionEventItem

class TransactionEvent(
    @SerializedName("blockNumber") override val blockNumber: String = "",
    @SerializedName("timeStamp") override val timeStamp: String = "",
    @SerializedName("hash") override val hash: String = "",
    @SerializedName("nonce") override val nonce: String = "",
    @SerializedName("blockHash") override val blockHash: String = "",
    @SerializedName("from") override val from: String = "",
    @SerializedName("contractAddress") override val contractAddress: String = "",
    @SerializedName("to") override val to: String = "",
    @SerializedName("value") override val value: String = "",
    @SerializedName("tokenName") override val tokenName: String = "",
    @SerializedName("tokenSymbol") override val tokenSymbol: String = "",
    @SerializedName("tokenDecimal") override val tokenDecimal: String = "",
    @SerializedName("transactionIndex") override val transactionIndex: String = "",
    @SerializedName("gas") override val gas: String = "",
    @SerializedName("gasPrice") override val gasPrice: String = "",
    @SerializedName("gasUsed") override val gasUsed: String = "",
    @SerializedName("cumulativeGasUsed") override val cumulativeGasUsed: String = "",
    @SerializedName("input") override val input: String = "",
    @SerializedName("confirmations") override val confirmations: String = "",
) : ITransactionEventItem