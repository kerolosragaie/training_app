package com.kerollosragaie.training_app.core.di

import android.content.Context
import androidx.room.Room
import com.kerollosragaie.training_app.core.dao.TrainingDao
import com.kerollosragaie.training_app.core.data_base.TrainingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTrainingDatabase(@ApplicationContext context: Context?): TrainingDatabase {
        return Room.databaseBuilder(context!!, TrainingDatabase::class.java, "app.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideTrainingDao(database: TrainingDatabase): TrainingDao {
        return database.getTrainingDao()

    }
}