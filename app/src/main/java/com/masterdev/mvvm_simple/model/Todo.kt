package com.masterdev.mvvm_simple.model

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean,
)