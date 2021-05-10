package com.jatsqi.todo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jatsqi.todo.db.dao.TodoDao
import com.jatsqi.todo.db.entity.TodoItem

@Database(entities = [ TodoItem::class ], version = 1)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao

}