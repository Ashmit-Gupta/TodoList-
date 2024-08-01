package com.ashmit.todolist.di
//8.

import android.app.Application
import androidx.room.Room
import com.ashmit.todolist.data.TodoDatabase
import com.ashmit.todolist.data.TodoRepository
import com.ashmit.todolist.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //this means only one single instance would be of the whole class ? A singleton is a design pattern that restricts the instantiation of a class to one "single" instance. This is useful when exactly one object is needed to coordinate actions across the system.

object AppModule {
    @Provides
    @Singleton
    fun provideTodoDatabase(app :Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db:TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.dao)
    }

}