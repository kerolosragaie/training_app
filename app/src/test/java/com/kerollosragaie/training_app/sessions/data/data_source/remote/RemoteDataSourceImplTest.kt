package com.kerollosragaie.training_app.sessions.data.data_source.remote

import com.google.gson.Gson
import com.kerollosragaie.training_app.sessions.data.models.TrainingSeries
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class RemoteDataSourceImplTest {

    @Test
    fun testGetTrainingSeries() = runBlocking {
        // Given
        val remoteDataSource = mockk<RemoteDataSource>()
        val gson = Gson()
        val expectedTrainingSeries = gson.fromJson(Remote_DATA, TrainingSeries::class.java)
        coEvery { remoteDataSource.getTrainingSeries() } returns expectedTrainingSeries

        // When
        val actualTrainingSeries = remoteDataSource.getTrainingSeries()

        // Then
        assertEquals(expectedTrainingSeries, actualTrainingSeries)
    }
}