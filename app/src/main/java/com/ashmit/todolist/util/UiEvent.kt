package com.ashmit.todolist.util

import androidx.compose.material3.SnackbarDuration

/*A sealed class in Kotlin is a special kind of class that allows you to define a restricted hierarchy of classes. All subclasses of a sealed class are known at compile-time, which makes it easier to manage and handle different types of events or states in your code.

Why Sealed Classes for UI Events?

UI events are finite, meaning there are only certain actions a user can take (e.g., navigating, showing a snackbar, going back). Sealed classes help enforce that all these cases are handled, and they prevent unexpected events from slipping through.
*/

sealed class UiEvent {
    object PopBackStack : UiEvent()// all the subclass will inherit or extend the UiEvent class
    data class Navigate(val route :String): UiEvent()
    data class ShowSnackBar(
        val message :String,
        val action :String? = null,
        val duration:SnackbarDuration
        ): UiEvent()
}

/*UiEvent is a sealed class that represents different types of user interface (UI) events that can occur in your application. This class helps manage and handle these events in a centralized and type-safe manner.

Purpose of the UiEvent Class
Centralized Event Handling:

The UiEvent class acts as a central place to define all possible UI events that can occur. Instead of handling each event separately across different parts of your app, you define them in one place and handle them accordingly.
Type-Safety:

Using a sealed class ensures that when you handle UiEvent in your ViewModel or UI, you have a well-defined set of events to work with. This makes your code more robust and easier to manage, as you can handle all possible cases at compile-time.


*/