package com.ashmit.todolist.ui.todo_list

import androidx.compose.material3.SnackbarDuration
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashmit.todolist.data.Todo
import com.ashmit.todolist.data.TodoRepository
import com.ashmit.todolist.util.Routes
import com.ashmit.todolist.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(private val repository : TodoRepository): ViewModel() {

    val todos = repository.getTodos()
    /*Channel:
A Channel is a Kotlin construct used for sending events or data between coroutines. It is a way to handle one-time events in a flow-based architecture.
Flow:
receiveAsFlow() converts the channel into a Flow that can be observed in the UI layer.
Why Use a Channel?
Channels are used here to send one-time UI events, like showing a snackbar or navigating to another screen. These events should only be handled once, so they are not suitable for LiveData or a StateFlow, which are used for state that should be observed continuously.*/
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    private var deletedTodo : Todo? = null
    fun onEvent(event : TodoListEvent){
        when(event){
            is TodoListEvent.OnTodoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO + "?todoId=${event.todo.id}"))
            }
            is TodoListEvent.OnAddTodoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TODO))
            }

            is TodoListEvent.OnDeleteTodoClick -> {
                viewModelScope.launch {
                    deletedTodo = event.todo
                    repository.deleteTodo(event.todo)
                    sendUiEvent(
                        UiEvent.ShowSnackBar(
                        message = "Todo deleted",
                        action = "Undo",
                            duration = SnackbarDuration.Short
                    ))
                }
            }
            is TodoListEvent.OnDoneChange -> {
                viewModelScope.launch {
                    repository.insertTodo(
                        event.todo.copy(
                            isDone = event.isDone
                        )
                    )
                }

            }
            TodoListEvent.onUndoDeleteClick -> {
                deletedTodo?.let {
                    todo ->
                    viewModelScope.launch {
                        repository.insertTodo(todo)
                    }
                }
            }
        }
    }

    private fun sendUiEvent(event : UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}