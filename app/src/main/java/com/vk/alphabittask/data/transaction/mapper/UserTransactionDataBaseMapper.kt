package com.vk.alphabittask.data.transaction.mapper

import com.vk.alphabittask.data.data_base.entity.ItemTransactionDbModel
import com.vk.alphabittask.data.network.response.TransactionEvent

object UserTransactionDataBaseMapper : BaseMapper<TransactionEvent, ItemTransactionDbModel>() {

    override fun transform(item: ItemTransactionDbModel): TransactionEvent {
        return TransactionEvent(
            blockHash = item.blockHash,
            blockNumber = item.blockNumber,
            timeStamp = item.timeStamp,
            hash = item.hash,
            nonce = item.nonce,
            from = item.from,
            contractAddress = item.contractAddress,
            to = item.to,
            value = item.value,
            tokenName = item.tokenName,
            tokenDecimal = item.tokenDecimal,
            tokenSymbol = item.tokenSymbol,
            transactionIndex = item.transactionIndex,
            gas = item.gas,
            gasPrice = item.gasPrice,
            gasUsed = item.gasUsed,
            cumulativeGasUsed = item.cumulativeGasUsed,
            input = item.input,
            confirmations = item.confirmations
        )
    }
}