package com.masterdev.mvvm_simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masterdev.mvvm_simple.adapter.TodoAdapter
import com.masterdev.mvvm_simple.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var rvTodo:RecyclerView
    private lateinit var todoAdapter:TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTodo = findViewById(R.id.rv_todo)
        rvTodo.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter()

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.getTodos()

        mainViewModel.todosLiveData.observe(this, Observer {
            todoAdapter.loadedState(it)
            rvTodo.adapter = todoAdapter
        })
    }
}