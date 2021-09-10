package com.example.kanbanboard.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.example.kanbanboard.R
import com.example.kanbanboard.databinding.FragmentHomeBinding
import com.example.kanbanboard.model.Board
import com.example.kanbanboard.ui.adapters.BoardAdapter
import com.example.kanbanboard.ui.adapters.BoardInteractionListener
import com.example.kanbanboard.viewModels.HomeViewModel
import android.app.Activity

import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.kanbanboard.ui.adapters.BaseRecycleAdapter


class HomeFragment:BaseFragment<FragmentHomeBinding>(),BoardInteractionListener {

    override val idLayout: Int= R.layout.fragment_home
    override val LOG_TAG: String ="Home_Fragment"

    val viewModel:HomeViewModel by viewModels()

    override val bindingInflater: (inflater: LayoutInflater, id: Int, container: ViewGroup?, b: Boolean) -> FragmentHomeBinding =DataBindingUtil::inflate

    override fun setup() {
        binding?.apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            deleteBoard=this@HomeFragment.viewModel
            addNewBoard.setOnClickListener { v ->
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_newBoardDialog)
            }
            recycleBoard.adapter=BoardAdapter(mutableListOf(),this@HomeFragment)

        }
    }
    override fun onClickBoard(board: Board) {
        Navigation.findNavController(requireActivity(),R.id.fragment_host)
            .navigate(
                HomeFragmentDirections.actionHomeFragmentToBoardFragment(board.boardId),
//                FragmentNavigatorExtras(chart to "chart")
            )
    }
}