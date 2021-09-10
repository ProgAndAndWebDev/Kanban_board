package com.example.kanbanboard.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanbanboard.model.Board
import com.example.kanbanboard.model.List
import com.example.kanbanboard.model.Repository
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

class NewListViewModel:ViewModel() {

    val listName= MutableLiveData<String>()

    fun addList(boardId:Int) {
        listName.value?.let {
            Repository.insertList(
                List(
                    boardId = boardId,
                    title = it,
                    createdDate = Date(),
                    lastUpdatedDate = Date()
                )
            ).subscribeOn(Schedulers.io())
                .subscribe()
        }
    }
}