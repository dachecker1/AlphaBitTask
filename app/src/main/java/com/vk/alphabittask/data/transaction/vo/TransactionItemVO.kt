package com.vk.alphabittask.data.transaction.vo

import android.os.Parcelable
import com.vk.alphabittask.domain.model.EqualityFunction
import com.vk.alphabittask.domain.model.ListItemModel
import kotlinx.parcelize.Parcelize

@Parcelize
class TransactionItemVO(
    var blockNumber: String = "",
    var timeStamp: String = "",
    var hash: String = "",
    var nonce: String = "",
    var blockHash: String = "",
    var from: String = "",
    var contractAddress: String = "",
    var to: String = "",
    var value: String = "",
    var tokenName: String = "",
    var tokenSymbol: String = "",
    var tokenDecimal: String = "",
    var transactionIndex: String = "",
    var gas: String = "",
    var gasPrice: String = "",
    var gasUsed: String = "",
    var cumulativeGasUsed: String = "",
    var input: String = "",
    var confirmations: String = "",
) : Parcelable, ListItemModel {
    override val identityEquality: EqualityFunction<ListItemModel>
        get() = object : EqualityFunction<ListItemModel> {
            override fun equal(a: ListItemModel, b: ListItemModel): Boolean {
                return (a as TransactionItemVO).hash == (b as TransactionItemVO).hash
            }
        }
    override val contentEquality: EqualityFunction<ListItemModel>
        get() = object : EqualityFunction<ListItemModel> {
            override fun equal(a: ListItemModel, b: ListItemModel): Boolean {
                return (a as TransactionItemVO).hash == (b as TransactionItemVO).hash
                        && a.timeStamp == b.timeStamp
                        && a.blockHash == b.blockHash
                        && a.blockNumber == b.blockNumber
            }
        }
}