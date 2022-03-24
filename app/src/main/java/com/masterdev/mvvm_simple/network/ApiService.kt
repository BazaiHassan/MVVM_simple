package com.masterdev.mvvm_simple.network

import com.masterdev.mvvm_simple.model.Todo
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("todos")
    fun getTodos():Call<ArrayList<Todo>>
}