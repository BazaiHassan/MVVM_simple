package com.masterdev.mvvm_simple.adapter

import android.content.Context
import android.widget.TextView
import com.masterdev.mvvm_simple.R
import com.masterdev.mvvm_simple.model.Todo
import io.github.farshidroohi.AdapterRecyclerView

class TodoAdapter : AdapterRecyclerView<Todo>(R.layout.item_todo,0,0,0) {
    override fun onBindView(
        viewHolder: ItemViewHolder,
        position: Int,
        context: Context,
        element: Todo?
    ) {
        val view = viewHolder.itemView

        val txtView = view.findViewById<TextView>(R.id.text_title)
        txtView.text = element?.title
    }
}