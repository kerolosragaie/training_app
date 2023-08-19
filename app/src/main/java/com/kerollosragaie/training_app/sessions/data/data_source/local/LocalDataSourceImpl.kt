package com.kerollosragaie.training_app.sessions.data.data_source.local

import com.kerollosragaie.training_app.core.dao.TrainingDao
import com.kerollosragaie.training_app.sessions.data.models.SeriesEntity

class LocalDataSourceImpl(private val trainingDao: TrainingDao) : LocalDataSource {
    override suspend fun insertTrainingSeries(series: SeriesEntity) {
        trainingDao.insertTrainingSeries(series)
    }

    override suspend fun getTrainingSeries(): SeriesEntity? = trainingDao.getTrainingSeries()
}