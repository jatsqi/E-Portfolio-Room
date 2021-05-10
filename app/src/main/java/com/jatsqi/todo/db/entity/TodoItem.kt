package com.jatsqi.todo.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "text")
    val text: String,

    @ColumnInfo(name = "is_done")
    var done: Boolean
)
