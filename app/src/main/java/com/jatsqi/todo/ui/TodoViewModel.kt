package com.jatsqi.todo.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.jatsqi.todo.db.TodoDatabase
import com.jatsqi.todo.db.entity.TodoItem
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {

    private val database =
        Room.databaseBuilder(application.applicationContext, TodoDatabase::class.java, "TodoDB").build()

    val items: LiveData<List<TodoItem>> = database.todoDao().getAllItems()

    fun onCreateButtonPress(text: String) {
        viewModelScope.launch {
            database.todoDao().createItem(
                TodoItem(
                    0,
                    text,
                    false
                )
            )
        }
    }

    fun onClickItemDone(item: TodoItem) {
        viewModelScope.launch {
            item.done = !item.done
            database.todoDao().updateItem(item)
        }
    }

}