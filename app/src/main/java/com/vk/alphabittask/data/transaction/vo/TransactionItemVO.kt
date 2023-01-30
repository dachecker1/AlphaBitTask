package com.vk.alphabittask.data.transaction.vo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class TransactionItemVO(
    var blockNumber : String = "",
    var timeStamp : String = "",
    var hash : String = "",
    var nonce : String = "",
    var blockHash : String = "",
    var from : String = "",
    var contractAddress : String = "",
    var to : String = "",
    var value : String = "",
    var tokenName : String = "",
    var tokenSymbol : String = "",
    var tokenDecimal : String = "",
    var transactionIndex : String = "",
    var gas : String = "",
    var gasPrice : String = "",
    var gasUsed : String = "",
    var cumulativeGasUsed : String = "",
    var input : String = "",
    var confirmations : String = ""
): Parcelable