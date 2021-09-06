package com.example.kanbanboard.model

import androidx.room.*
import java.util.*

@Entity(tableName = "Card_Table",foreignKeys = [
    ForeignKey(
        entity = List::class,
        parentColumns = arrayOf("listId"),
        childColumns = arrayOf("listId"),
        onDelete = ForeignKey.CASCADE
    )
])
data class Card (
    @PrimaryKey(autoGenerate = true)val cardId:Int=0,
    val title: String,
    @ColumnInfo(index = true) var listId:Int,
    var description:String,
    var order:Float=0.0f,
    val createdDate:Date,
    val lastUpdatedDate: Date,
)
