package com.kerollosragaie.training_app.sessions.data.data_source.local


import com.kerollosragaie.training_app.sessions.data.models.SeriesEntity

interface LocalDataSource {

    suspend fun insertTrainingSeries(series: SeriesEntity)

    suspend fun getTrainingSeries(): SeriesEntity?

}