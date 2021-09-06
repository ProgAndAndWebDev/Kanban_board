package com.example.kanbanboard.model

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@androidx.room.Database(entities = [Board::class,List::class,Card::class,Item::class],version = 1)
@TypeConverters(Converter::class)
abstract class Database:RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{

        private const val DATABASE_NAME="Kanban_DATABASE"

        @Volatile private var instance:Database?=null

        fun getInstance(context: Context)=
            instance ?: synchronized(this){ buildDatabase(context).also{ instance=it}}

        fun getInstanceWithoutContext()=
            instance!!

        private fun buildDatabase(context: Context): Database =
            Room.databaseBuilder(context,Database::class.java, DATABASE_NAME).build()

    }
}