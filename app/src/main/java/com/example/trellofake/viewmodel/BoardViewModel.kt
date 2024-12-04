package com.example.trellofake.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trellofake.model.Board
import com.example.trellofake.model.TaskList

class BoardViewModel : ViewModel() {

    private val _boards = MutableLiveData<List<Board>>(emptyList())
    val boards: LiveData<List<Board>> = _boards

    // Add a new board
    fun addBoard(name: String) {
        val updatedBoards = _boards.value?.toMutableList() ?: mutableListOf()
        updatedBoards.add(Board(name = name))
        _boards.value = updatedBoards
    }

    // Remove a board by ID
    fun removeBoard(boardId: String) {
        _boards.value = _boards.value?.filterNot { it.id == boardId }
    }

    // Update a board (e.g., add a category)
    fun addCategoryToBoard(boardId: String, taskListName: String) {
        val updatedBoards = _boards.value?.map { board ->
            if (board.id == boardId) {
                board.tasklists.add(TaskList(name = taskListName))
            }
            board
        }
        _boards.value = updatedBoards
    }
}