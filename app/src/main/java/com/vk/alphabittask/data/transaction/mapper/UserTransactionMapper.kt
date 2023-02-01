package com.vk.alphabittask.data.transaction.mapper

import com.vk.alphabittask.data.transaction.vo.TransactionItemVO
import com.vk.alphabittask.data.network.response.TransactionEvent

object UserTransactionMapper : BaseMapper<TransactionItemVO, TransactionEvent>() {

    override fun transform(item: TransactionEvent): TransactionItemVO {
        return TransactionItemVO(
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