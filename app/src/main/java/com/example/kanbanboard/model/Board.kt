package com.example.kanbanboard.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Board_Table")
data class Board(
    @PrimaryKey(autoGenerate = true) var boardId :Int=0,
    var title: String,
    var createdDate:Date,
    var favourite:Boolean=false,
    var lastUpdateDate:Date,
)
