package com.vk.alphabittask.data.data_base.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionList")
data class ItemTransactionDbModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int?,
    @ColumnInfo(name = "blockNumber")
    val blockNumber : String,
    @ColumnInfo(name = "timeStamp")
    val timeStamp : String,
    @ColumnInfo(name = "hash")
    val hash : String,
    @ColumnInfo(name = "nonce")
    val nonce : String,
    @ColumnInfo(name = "blockHash")
    val blockHash : String,
    @ColumnInfo(name = "from")
    val from : String,
    @ColumnInfo(name = "contractAddress")
    val contractAddress : String,
    @ColumnInfo(name = "to")
    val to : String,
    @ColumnInfo(name = "value")
    val value : String,
    @ColumnInfo(name = "tokenName")
    val tokenName : String,
    @ColumnInfo(name = "tokenSymbol")
    val tokenSymbol : String,
    @ColumnInfo(name = "tokenDecimal")
    val tokenDecimal : String,
    @ColumnInfo(name = "transactionIndex")
    val transactionIndex : String,
    @ColumnInfo(name = "gas")
    val gas : String,
    @ColumnInfo(name = "gasPrice")
    val gasPrice : String,
    @ColumnInfo(name = "gasUsed")
    val gasUsed : String,
    @ColumnInfo(name = "cumulativeGasUsed")
    val cumulativeGasUsed : String,
    @ColumnInfo(name = "input")
    val input : String,
    @ColumnInfo(name = "confirmations")
    val confirmations : String
)