package com.kerollosragaie.training_app.sessions.domain.repos

import com.kerollosragaie.training_app.sessions.data.models.TrainingSeries

interface TrainingSeriesRepo {
    suspend fun getTrainingSeries(): TrainingSeries
}