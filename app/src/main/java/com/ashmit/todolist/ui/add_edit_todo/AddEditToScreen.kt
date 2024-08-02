package com.ashmit.todolist.ui.add_edit_todo

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ashmit.todolist.util.UiEvent
import kotlinx.coroutines.launch

@Composable
fun AddEditTodoScreen(onPopBackStack: () -> Unit, viewModel: AddEditTodoViewModel = hiltViewModel()) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            Log.d("DEBUG" ,"event is : ${event.toString()}" )
            when (event) {
                is UiEvent.Navigate -> null

                is UiEvent.ShowSnackBar -> {
//                    scope.launch {
//                        Log.d("DEBUG", "ShowSnackBar event received")
//                        snackbarHostState.showSnackbar(
//                            message = "Event ka msg or kya , ke hi kaar le ?",
//                            actionLabel = "Water Slide"
//                        )
//                    }
                }
                // the UiEvent.PopBackStack is only working as i have only passed the UiEvent.sent(UieEvent.popBackStack) only so the other wold nt work , the other are for only completion of the task
                is UiEvent.PopBackStack -> onPopBackStack()
            }

        }

    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddEditTodoEvent.OnSaveTodoClick)
            }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Save")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Apply padding to ensure content is not obscured by FAB
        ) {
            TextField(
                value = viewModel.title,
                onValueChange = {
                    viewModel.onEvent(AddEditTodoEvent.OnTitleChange(it))
                },
                placeholder = {
                    Text(text = "Title")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = viewModel.description,
                onValueChange = {
                    viewModel.onEvent(AddEditTodoEvent.OnDescriptionChange(it))
                },
                placeholder = {
                    Text(text = "Description")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = false,
                maxLines = 5
            )
        }
    }
}
