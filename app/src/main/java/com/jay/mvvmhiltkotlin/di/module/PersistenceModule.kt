package com.jay.mvvmhiltkotlin.di.module

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.jay.mvvmhiltkotlin.room.AppDatabase
import com.jay.mvvmhiltkotlin.room.PersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Module which provides all required dependencies about local Room Database
 */
@Module
@InstallIn(ApplicationComponent::class)
class PersistenceModule {

  @Provides
  @Singleton
  fun provideDatabase(@NonNull application: Application): AppDatabase {
    return Room
      .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
      .build()
  }

  @Provides
  @Singleton
  fun providePersonDao(@NonNull database: AppDatabase): PersonDao {
    return database.getPerson()
  }

  //Add future DAO providers here...
}
