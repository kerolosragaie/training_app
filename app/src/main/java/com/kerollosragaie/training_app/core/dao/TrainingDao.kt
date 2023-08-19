package com.kerollosragaie.training_app.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kerollosragaie.training_app.sessions.data.models.SeriesEntity

@Dao
interface TrainingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrainingSeries(series: SeriesEntity)

    @Query("SELECT * FROM SeriesEntity")
    suspend fun getTrainingSeries(): SeriesEntity?

}