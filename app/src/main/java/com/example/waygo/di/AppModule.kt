package com.example.waygo.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.waygo.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.waygo.data.SharedPrefsManager
import com.example.waygo.data.local.AppDatabase
import com.example.waygo.data.local.dao.SubTaskDao
import com.example.waygo.data.local.dao.TaskDao
import com.example.waygo.domain.repository.TaskRepository
import com.example.waygo.data.TaskRepositoryImpl
import com.example.waygo.ui.viewmodel.FormValidationViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences =
        context.getSharedPreferences("${BuildConfig.APPLICATION_ID}_preferences", Context.MODE_PRIVATE)

    // context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE) //bad implementation

    @Provides
    @Singleton
    fun provideSharedPrefsManager(
        sharedPreferences: SharedPreferences,
        @ApplicationContext context: Context
    ): SharedPrefsManager =
        SharedPrefsManager(sharedPreferences, context)



    @Provides
    @Singleton
    fun provideFormValidationViewModel(
        @ApplicationContext context: Context
    ): FormValidationViewModel = FormValidationViewModel(context)


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my_database_name"
        ).build()
    }

    @Provides
    fun provideTaskDao(db: AppDatabase): TaskDao = db.taskDao()

    @Provides
    fun provideSubTaskDao(db: AppDatabase): SubTaskDao = db.subTaskDao()

    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao, subTaskDao: SubTaskDao): TaskRepository = TaskRepositoryImpl(taskDao, subTaskDao)

}
