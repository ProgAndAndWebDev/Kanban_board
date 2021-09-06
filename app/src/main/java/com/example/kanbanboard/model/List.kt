package com.example.kanbanboard.model

import androidx.room.*
import java.util.*

@Entity(
    tableName = "List_Table",
    foreignKeys = [
        ForeignKey(
            entity = Board::class,
            parentColumns = arrayOf("boardId"),
            childColumns = arrayOf("boardId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class List(
    @PrimaryKey(autoGenerate = true)var listId :Int=0,
    val title:String,
    @ColumnInfo(index = true) val boardId:Int,
    var order:Float=0.0f,
    val createdDate:Date,
    val lastUpdatedDate: Date,
)
