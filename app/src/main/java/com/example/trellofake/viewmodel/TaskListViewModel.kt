package com.example.trellofake.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trellofake.model.Card
import com.example.trellofake.model.TaskList

class TaskListViewModel : ViewModel() {
    private val  _tasklists = MutableLiveData<List<TaskList>>(emptyList())
    val tasklists: LiveData<List<TaskList>> = _tasklists




    fun addTaskList(name:String){
        val updatedTaskLists = _tasklists.value?.toMutableList()?: mutableListOf()
        updatedTaskLists.add(TaskList(name = name))
        _tasklists.value = updatedTaskLists
    }

    fun removeTaskList(tasklistId:String){
        _tasklists.value = _tasklists.value?.filterNot {it.id == tasklistId}
    }

    fun addCardToTaskList(tasklistId: String,cardTitle:String,cardDescription:String?){
        val updatedTaskLists = _tasklists.value?.map { tasklist ->
            if (tasklist.id == tasklistId){
                tasklist.cards.add(Card(title=cardTitle, description = cardDescription))
            }
            tasklist
        }
        _tasklists.value = updatedTaskLists
    }

}