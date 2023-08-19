package com.kerollosragaie.training_app.sessions.data.repos

import com.google.gson.Gson
import com.kerollosragaie.training_app.sessions.data.data_source.local.LocalDataSource
import com.kerollosragaie.training_app.sessions.data.data_source.remote.RemoteDataSource
import com.kerollosragaie.training_app.sessions.data.models.SeriesEntity
import com.kerollosragaie.training_app.sessions.data.models.SocialPost
import com.kerollosragaie.training_app.sessions.data.models.TrainingSeries
import com.kerollosragaie.training_app.sessions.data.models.TrainingSery
import com.kerollosragaie.training_app.sessions.domain.repos.TrainingSeriesRepo
import javax.inject.Inject

class TrainingSeriesRepoImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : TrainingSeriesRepo {
    override suspend fun getTrainingSeries(): TrainingSeries {
        val localData = localDataSource.getTrainingSeries()
        return if (localData != null) {
            val trainingSer =
                Gson().fromJson(localData.trainingSeries, Array<TrainingSery>::class.java).toList()
            val socialPosts =
                Gson().fromJson(localData.socialPostsContent, Array<SocialPost>::class.java).toList()

            TrainingSeries(localData.id, socialPosts, trainingSer)
        } else {
            val remoteData = remoteDataSource.getTrainingSeries()
            val seriesEntity = SeriesEntity(
                remoteData.id,
                Gson().toJson(remoteData.trainingSeries),
                Gson().toJson(remoteData.socialPosts),
            )
            localDataSource.insertTrainingSeries(seriesEntity)
            remoteData
        }
    }
}