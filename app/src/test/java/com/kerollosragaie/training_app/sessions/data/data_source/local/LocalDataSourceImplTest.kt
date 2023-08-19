package com.kerollosragaie.training_app.sessions.data.data_source.local

import com.kerollosragaie.training_app.core.dao.TrainingDao
import com.kerollosragaie.training_app.sessions.data.models.SeriesEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LocalDataSourceImplTest {
    private lateinit var localDataSource: LocalDataSourceImpl
    private lateinit var trainingDao: TrainingDao

    @Before
    fun setup() {
        trainingDao = mockk()
        localDataSource = LocalDataSourceImpl(trainingDao)
    }

    @Test
    fun `insertTrainingSeries should call insertTrainingSeries on TrainingDao`() = runBlocking {
        // Given
        val series = SeriesEntity(1,"","")
        coEvery { trainingDao.insertTrainingSeries(series) } returns Unit

        // When
        localDataSource.insertTrainingSeries(series)

        // Then
        coVerify { trainingDao.insertTrainingSeries(series) }
    }

    @Test
    fun `getTrainingSeries should return the result from TrainingDao`() = runBlocking {
        // Given
        val seriesEntity = SeriesEntity(1,"","")
        coEvery { trainingDao.getTrainingSeries() } returns seriesEntity

        // When
        val result = localDataSource.getTrainingSeries()

        // Then
        assertEquals(seriesEntity, result)
    }
}