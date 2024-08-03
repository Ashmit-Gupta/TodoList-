# To-Do List Application

This is a simple To-Do List application built using the MVVM (Model-View-ViewModel) architectural pattern in Android. The app allows users to add, edit, delete, and mark tasks as completed. It leverages several modern Android libraries and best practices, including Jetpack Compose, Room database, Dagger Hilt for dependency injection, and Kotlin coroutines.

## Features

- **Add To-Do**: Users can add new tasks with a title and optional description.
- **Edit To-Do**: Users can edit the details of existing tasks.
- **Delete To-Do**: Users can delete tasks.
- **Mark as Done**: Users can mark tasks as completed.
- **Undo Delete**: Snackbar allows users to undo accidental deletions.

## Architecture

The application follows the MVVM architecture pattern:

- **Model**: Represents the data layer of the app. This includes the Room database, DAO, and the repository.
- **View**: The UI layer, built using Jetpack Compose. The view observes the ViewModel for data updates and displays the data.
- **ViewModel**: Acts as a bridge between the View and Model. It fetches data from the repository and prepares it for display in the View.

## Libraries Used

- **Jetpack Compose**: For building the UI.
- **Room**: For local data storage.
- **Dagger Hilt**: For dependency injection.
- **Kotlin Coroutines**: For asynchronous programming.
- **StateFlow**: For reactive data handling in the ViewModel.

## Project Structure

- `data/`: Contains the data models, DAOs, and Room database setup.
- `ui/`: Contains the UI components built using Jetpack Compose.
  - `todo_list/`: Contains the screens related to the To-Do list.
- `viewmodel/`: Contains the ViewModels that interact with the repository.
- `di/`: Dependency injection setup using Dagger Hilt.
- `util/`: Utility classes like event classes for managing UI events.
