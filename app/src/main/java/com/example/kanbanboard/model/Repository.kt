package com.example.kanbanboard.model

object Repository {

    val dao=Database.getInstanceWithoutContext().getDao()

    fun insertBoard(board: Board)=
        dao.insertBoard(board)

    fun insertList(list: List)=
        dao.insertList(list)

    fun insertCard(card: Card)=
        dao.insertCard(card)
    fun getAllBoards()=
        dao.getAllBoard()

    fun getBoardByID(boardId:Int)=
        dao.getBoard(boardId)

    fun getCardsByListId(listId:Int)=
        dao.getCardsByListID(listId)

    fun getListsByBoardId(boardId:Int)=
        dao.getListsByBoardId(boardId)
}