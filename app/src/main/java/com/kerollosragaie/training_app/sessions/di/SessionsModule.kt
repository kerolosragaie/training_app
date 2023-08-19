package com.kerollosragaie.training_app.sessions.di

import com.kerollosragaie.training_app.core.dao.TrainingDao
import com.kerollosragaie.training_app.sessions.data.data_source.local.LocalDataSource
import com.kerollosragaie.training_app.sessions.data.data_source.local.LocalDataSourceImpl
import com.kerollosragaie.training_app.sessions.data.data_source.remote.RemoteDataSource
import com.kerollosragaie.training_app.sessions.data.data_source.remote.RemoteDataSourceImpl
import com.kerollosragaie.training_app.sessions.data.repos.TrainingSeriesRepoImpl
import com.kerollosragaie.training_app.sessions.domain.repos.TrainingSeriesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SessionsModule {

    @Provides
    fun provideTrainingSeriesRepo(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): TrainingSeriesRepo = TrainingSeriesRepoImpl(localDataSource, remoteDataSource)

    @Provides
    fun provideRemoteDataSource(): RemoteDataSource =
        RemoteDataSourceImpl()


    @Provides
    fun provideLocalDataSource(trainingDao: TrainingDao): LocalDataSource =
        LocalDataSourceImpl(trainingDao)

}