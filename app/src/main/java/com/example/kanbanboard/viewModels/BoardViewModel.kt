package com.example.kanbanboard.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanbanboard.model.Board
import com.example.kanbanboard.model.Card
import com.example.kanbanboard.model.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class BoardViewModel(private val id:Int)
    :ViewModel() {

    val currentBoard = MutableLiveData<Board>()
    val currentLists = MutableLiveData<List<com.example.kanbanboard.model.List>>()

    init {
        Log.i("TAG", "$id")
        getBoard()
        getLists()
    }

    private fun getBoard() {
        Repository.getBoardByID(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccess, this::onFail)
    }

    private fun onSuccess(board: Board) {
        currentBoard.postValue(board)
    }

    private fun onFail(throwable: Throwable) {
        Log.i("TAG", throwable.message.toString())
    }

    fun getLists() {
        Repository.getListsByBoardId(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                currentLists.postValue(list)
            }, this::onFail)

    }

}