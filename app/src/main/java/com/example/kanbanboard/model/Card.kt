package com.example.kanbanboard.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.room.*
import androidx.versionedparcelable.ParcelField
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
    val createdDate:Date,
    val lastUpdatedDate: Date,
)
