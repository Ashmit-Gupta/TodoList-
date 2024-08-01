package com.ashmit.todolist.data
//3.
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Todo::class], //so this means that what col will be there in the database
    version = 1
)
abstract class TodoDatabase : RoomDatabase() {
    abstract val dao : ToDoDAO
}