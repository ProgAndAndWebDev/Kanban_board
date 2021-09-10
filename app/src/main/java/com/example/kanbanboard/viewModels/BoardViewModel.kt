package com.example.kanbanboard.viewModels

import android.util.Log
import androidx.lifecycle.*
import com.example.kanbanboard.model.Board
import com.example.kanbanboard.model.Card
import com.example.kanbanboard.model.Repository
import com.example.kanbanboard.ui.adapters.ICreate
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.*

class BoardViewModel(private val id:Int)
    :ViewModel() {

    val currentBoard = MutableLiveData<Board>()
    val currentLists = MutableLiveData<List<com.example.kanbanboard.model.List>>()
    val cards = MutableLiveData<List<Card>>()



    init {
        getBoard()
        viewModelScope.launch {
            getLists()
            currentLists.value?.map { it.listId }?.let { getCards(it) }
        }
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

    private fun getCards(id: List<Int>){
        Repository.getAllCards(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ card ->
                cards.postValue(card)
            },
                this::onFail)
    }
}