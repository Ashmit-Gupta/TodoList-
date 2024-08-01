package com.ashmit.todolist.data
//2.
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
//A DAO (Data Access Object) is a design pattern used to separate the data persistence logic from the business logic in an application. In the context of Android development, especially when using Room (a persistence library that provides an abstraction layer over SQLite), DAOs are used to define methods for interacting with the database.

/*
Annotations for CRUD Operations: DAOs use various Room annotations to define SQL queries and operations:
    a DAO is typically an interface or an abstract class that is annotated with @Dao.
    @Insert: To insert data into the database.
    @Update: To update existing data.
    @Delete: To delete data.
    @Query: To write custom SQL queries for more complex operations.

 */
@Dao
interface ToDoDAO {
    //this will insert the item in db
    //suspend ->
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo : Todo)

    @Delete
    suspend fun deleteTodo(todo : Todo)

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id :Int) : Todo?

    @Query("SELECT * FROM todo")
    fun getTodos() : Flow<List<Todo>>

}