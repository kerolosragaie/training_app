package com.kerollosragaie.training_app.sessions.data.data_source.remote

import com.kerollosragaie.training_app.sessions.data.models.TrainingSeries

interface RemoteDataSource {
    suspend fun getTrainingSeries(): TrainingSeries
}