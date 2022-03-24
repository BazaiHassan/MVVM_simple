package com.masterdev.mvvm_simple.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masterdev.mvvm_simple.model.Todo
import com.masterdev.mvvm_simple.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _todosLiveData = MutableLiveData<ArrayList<Todo>>()

    val todosLiveData: LiveData<ArrayList<Todo>> get() = _todosLiveData

    fun getTodos() {
        repository.getTodos?.enqueue(object : Callback<ArrayList<Todo>> {
            override fun onResponse(
                call: Call<ArrayList<Todo>>,
                response: Response<ArrayList<Todo>>
            ) {
                _todosLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<Todo>>, t: Throwable) {

            }

        })
    }
}