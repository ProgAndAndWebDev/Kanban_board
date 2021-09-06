package com.example.kanbanboard.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "Item_Table",foreignKeys = [
    ForeignKey(
        entity = Card::class,
        parentColumns = arrayOf("cardId"),
        childColumns = arrayOf("cardId"),
        onDelete = ForeignKey.CASCADE
    )
])
data class Item(
    @PrimaryKey(autoGenerate = true)val itemId:Int=0,
    var title:String,
    @ColumnInfo(index = true)val cardId:Int,
    val done:Boolean=false,
    val createdDate:Date,
    var lastUpdatedDate: Date,
)