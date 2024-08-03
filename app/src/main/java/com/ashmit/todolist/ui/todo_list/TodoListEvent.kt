package com.ashmit.todolist.ui.todo_list

import com.ashmit.todolist.data.Todo

//TodoListEvent is similar to UiEvent in that it represents different actions or events that can occur in the TodoListScreen. Just like UiEvent is used to handle UI-related events in your app, TodoListEvent can be used to handle various user interactions and actions specific to the TodoListScreen.

sealed class TodoListEvent {
    data class OnDeleteTodoClick(val todo: Todo) : TodoListEvent()
    data class OnDoneChange (val todo: Todo, val isDone:Boolean): TodoListEvent()
    object onUndoDeleteClick : TodoListEvent()
    data class OnTodoClick(val todo :Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}