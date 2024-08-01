package com.ashmit.todolist.data
//1.
import androidx.room.Entity
import androidx.room.PrimaryKey

//represents a to-do item
//@Entity, indicating that it is a table in a Room database (Room is a persistence library in Android that provides an abstraction layer over SQLite).
@Entity
data class Todo(
    val title :String,
    val description :String?,
    val isDone : Boolean,
    @PrimaryKey val id:Int? = null
)