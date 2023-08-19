package com.kerollosragaie.training_app.sessions.data.repos

import com.google.gson.Gson
import com.kerollosragaie.training_app.sessions.data.data_source.local.LocalDataSource
import com.kerollosragaie.training_app.sessions.data.data_source.remote.RemoteDataSource
import com.kerollosragaie.training_app.sessions.data.models.SeriesEntity
import com.kerollosragaie.training_app.sessions.data.models.TrainingSeries
import com.kerollosragaie.training_app.sessions.domain.repos.TrainingSeriesRepo
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class TrainingSeriesRepoImplTest {

    private lateinit var trainingSeriesRepo: TrainingSeriesRepo
    private val localDataSource: LocalDataSource = mockk()
    private val remoteDataSource: RemoteDataSource = mockk()
    private val gson: Gson = Gson()

    @Before
    fun setup() {
        trainingSeriesRepo = TrainingSeriesRepoImpl(localDataSource, remoteDataSource)
    }

    @Test
    fun testGetTrainingSeries_localDataNotNull() = runBlocking {
        // Given
        val localData = TrainingSeries(1, emptyList(), emptyList())
        val localSeriesEntity = SeriesEntity(
            localData.id,
            gson.toJson(localData.trainingSeries),
            gson.toJson(localData.socialPosts)
        )

        coEvery { localDataSource.getTrainingSeries() } returns localSeriesEntity

        // When
        val result = trainingSeriesRepo.getTrainingSeries()

        // Then
        assertEquals(localData, result)
    }

    @Test
    fun testGetTrainingSeries_localDataNull() = runBlocking {
        // Given
        val remoteData = TrainingSeries(1, emptyList(), emptyList())
        val remoteSeriesEntity = SeriesEntity(
            remoteData.id,
            remoteData.trainingSeries.toString(),
            remoteData.socialPosts.toString()
        )

        coEvery { localDataSource.getTrainingSeries() } returns null
        coEvery { remoteDataSource.getTrainingSeries() } returns remoteData
        coEvery { localDataSource.insertTrainingSeries(any()) } returns Unit

        // When
        val result = trainingSeriesRepo.getTrainingSeries()

        // Then
        assertEquals(remoteData, result)
    }
}