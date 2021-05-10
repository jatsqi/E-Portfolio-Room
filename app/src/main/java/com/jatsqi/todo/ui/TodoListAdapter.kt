package com.jatsqi.todo.ui

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jatsqi.todo.R
import com.jatsqi.todo.db.entity.TodoItem

class TodoListAdapter(private val onItemDoneClick: (TodoItem) -> Unit) :
    RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    private var todoItems: List<TodoItem> = emptyList()

    class TodoViewHolder(
        itemView: View,
        val textView: TextView = itemView.findViewById(R.id.todo_item_text),
        val doneCheckBox: CheckBox = itemView.findViewById(R.id.todo_item_done)
    ) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = todoItems[position]

        holder.textView.text = item.text
        setTextStrikeThruEffect(holder.textView, item.done)

        holder.doneCheckBox.isChecked = item.done
        holder.doneCheckBox.setOnClickListener {
            onItemDoneClick(item)
        }
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    fun changeItems(items: List<TodoItem>) {
        todoItems = items
    }

    private fun setTextStrikeThruEffect(view: TextView, enable: Boolean) {
        if (enable) {
            view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            view.paintFlags = 0
        }
    }

}