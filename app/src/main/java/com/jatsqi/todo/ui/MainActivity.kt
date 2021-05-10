package com.jatsqi.todo.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.jatsqi.todo.R
import com.jatsqi.todo.db.TodoDatabase
import com.jatsqi.todo.db.entity.TodoItem

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TodoListAdapter
    private val viewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = findViewById<RecyclerView>(R.id.todo_list)
        val adapter = TodoListAdapter(onItemDoneClick = { item ->
            viewModel.onClickItemDone(item)
        })
        todoList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        todoList.adapter = adapter

        viewModel.items.observe(this) {
            adapter.changeItems(it)
            adapter.notifyDataSetChanged()
        }

        val button = findViewById<Button>(R.id.todo_add)
        val text = findViewById<TextView>(R.id.todo_input)

        button.setOnClickListener {
            viewModel.onCreateButtonPress(text.text.toString())
        }
    }
}