package com.kerollosragaie.training_app.core.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kerollosragaie.training_app.core.dao.TrainingDao
import com.kerollosragaie.training_app.sessions.data.models.SeriesEntity

@Database(
    version = 1,
    entities = [SeriesEntity::class,],
)
abstract class TrainingDatabase : RoomDatabase() {

    abstract fun getTrainingDao(): TrainingDao

}