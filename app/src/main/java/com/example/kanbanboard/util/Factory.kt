package com.example.kanbanboard.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kanbanboard.viewModels.BoardViewModel

class Factory(private val params: Int) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BoardViewModel::class.java)) {
            return BoardViewModel(params) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
