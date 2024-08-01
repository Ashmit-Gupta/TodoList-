package com.ashmit.todolist.data

import kotlinx.coroutines.flow.Flow
//4.
interface TodoRepository {
    suspend fun insertTodo(todo : Todo)

    suspend fun deleteTodo(todo : Todo)

    suspend fun getTodoById(id :Int) : Todo?

    fun getTodos() : Flow<List<Todo>>
}