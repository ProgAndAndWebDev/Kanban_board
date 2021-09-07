package com.example.kanbanboard.model

import androidx.room.*
import androidx.room.Dao
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface Dao {

    @Insert
    fun insertBoard(board: Board):Completable

    @Insert
     fun insertList(list: List):Completable

    @Insert
     fun insertCard(card: Card):Completable

    @Insert
     fun insertItem(item: Item):Completable


    @Update
     fun update(board: Board):Completable

    @Update
     fun update(card: Card):Completable

    @Update
     fun update(list: List):Completable

    @Update
     fun update(item: Item):Completable


    @Delete
     fun delete(board: Board):Completable

    @Delete
     fun delete(card: Card):Completable

    @Delete
     fun delete(list: List):Completable

    @Delete
     fun delete(item: Item):Completable


    @Query("SELECT * FROM Board_Table ORDER BY lastUpdateDate DESC")
    fun getAllBoard(): Observable<kotlin.collections.List<Board>>

    @Query("SELECT * FROM Card_Table")
    fun getAllCard(): Observable<kotlin.collections.List<Card>>


    @Query("SELECT * FROM List_Table")
    fun getAllList(): Observable<kotlin.collections.List<List>>

    @Query("SELECT * FROM Item_Table")
    fun getAllItem(): Observable<kotlin.collections.List<Item>>

    @Query("SELECT * FROM Board_Table WHERE boardId == :boardId ")
    fun getBoard(boardId:Int): Observable<Board>

    @Query("SELECT * FROM Card_Table WHERE listId == :listId ")
    fun getCardsByListID(listId:Int): Observable<kotlin.collections.List<Card>>

    @Query("SELECT * FROM List_Table WHERE boardId == :boardId ")
    fun getListsByBoardId(boardId:Int): Observable<kotlin.collections.List<List>>

    @Query("SELECT * FROM Board_Table WHERE title LIKE :keyword ORDER BY lastUpdateDate DESC")
    fun filterByName (keyword:String): Observable<kotlin.collections.List<Board>>



}