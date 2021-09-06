package com.example.kanbanboard.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.kanbanboard.R
import com.example.kanbanboard.databinding.FragmentBoardBinding
import com.example.kanbanboard.model.Card
import com.example.kanbanboard.ui.adapters.CardInteractionListener
import com.example.kanbanboard.ui.adapters.ListInteractionListener
import com.example.kanbanboard.ui.adapters.NestedRecyclerAdapter
import com.example.kanbanboard.util.Factory
import com.example.kanbanboard.viewModels.BoardViewModel

class BoardFragment:BaseFragment<FragmentBoardBinding>(),ListInteractionListener,CardInteractionListener {
    val args:BoardFragmentArgs by navArgs()
    override val idLayout: Int= R.layout.fragment_board
    override val LOG_TAG: String ="BoardFragment"
    private lateinit var viewModel: BoardViewModel
    private lateinit var viewModelFactory: Factory
    override val bindingInflater: (inflater: LayoutInflater, id: Int, container: ViewGroup?, b: Boolean) -> FragmentBoardBinding =DataBindingUtil::inflate

    override fun setup() {
        binding?.apply {
            this.viewModel=this@BoardFragment.viewModel
            lifecycleOwner=viewLifecycleOwner
            recycleList.adapter=NestedRecyclerAdapter(mutableListOf(),this@BoardFragment,this@BoardFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFactory = Factory(args.boardId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(BoardViewModel::class.java)
        return super.onCreateView(inflater, container, savedInstanceState)
         }

    override fun onClick() {

    }

    override fun onClickCard(card: Card) {

    }
}