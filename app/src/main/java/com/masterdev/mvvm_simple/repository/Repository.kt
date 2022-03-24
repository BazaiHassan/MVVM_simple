package com.masterdev.mvvm_simple.repository

import com.masterdev.mvvm_simple.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Repository {

    fun  getRetrofit():Retrofit?{
        var retrofit: Retrofit? = null
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit
    }

    var service = getRetrofit()?.create(ApiService::class.java)
    var getTodos = service?.getTodos()
}