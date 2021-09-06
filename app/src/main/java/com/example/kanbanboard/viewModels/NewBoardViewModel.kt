package com.example.kanbanboard.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanbanboard.model.Board
import com.example.kanbanboard.model.Repository
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class NewBoardViewModel:ViewModel() {
    val BoardName=MutableLiveData<String>()

    fun addBoard(){
        BoardName.value?.let {
            Repository.insertBoard(
                Board(
                    title = it,
                    createdDate = Date(),
                    lastUpdateDate = Date()
                )
            ).subscribeOn(Schedulers.io())
                .subscribe()
        }

    }
}