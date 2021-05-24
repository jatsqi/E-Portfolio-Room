package com.jatsqi.todo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jatsqi.todo.db.entity.TodoItem

@Dao
interface TodoDao {
    @Insert
    suspend fun createItem(item: TodoItem)

    @Query("SELECT * FROM TodoItem")
    fun getAllItems(): LiveData<List<TodoItem>>

    @Update
    suspend fun updateItem(item: TodoItem)
}