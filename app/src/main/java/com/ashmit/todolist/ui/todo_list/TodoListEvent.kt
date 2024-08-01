package com.ashmit.todolist.ui.todo_list

import com.ashmit.todolist.data.Todo


sealed class TodoListEvent {

    data class OnDeleteTodoClick(val todo: Todo) : TodoListEvent()
    data class OnDoneChange (val todo: Todo, val isDone:Boolean): TodoListEvent()
    object onUndoDeleteClick : TodoListEvent()
    data class OnTodoClick(val todo :Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}