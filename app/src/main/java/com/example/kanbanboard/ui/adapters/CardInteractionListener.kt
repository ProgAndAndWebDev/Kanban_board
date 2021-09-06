package com.example.kanbanboard.ui.adapters

import com.example.kanbanboard.model.Card

interface CardInteractionListener :BaseInteraction{

    fun onClickCard(card: Card)
}
