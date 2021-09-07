package com.example.kanbanboard.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kanbanboard.model.Board
import com.example.kanbanboard.model.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    val boards=MutableLiveData<List<Board>>()
    val search= MutableStateFlow<String?>(null)

    init {
        getBoards()
        filter()
    }

    private fun getBoards() {
        Repository.getAllBoards()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this@HomeViewModel::onSuccess,this@HomeViewModel::onFail)
    }

    private fun filter(){
        viewModelScope.launch {
            search.collect {
                it?.let {
                    Repository.filterBoardByKeyword(it)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this@HomeViewModel::onSuccess,this@HomeViewModel::onFail)
                }
            }
        }
    }

    private fun onFail(throwable: Throwable){
        Log.i("TAG",throwable.message.toString())
    }

    private fun onSuccess(list: List<Board>){
        boards.postValue(list)
    }

}