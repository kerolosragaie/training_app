package com.kerollosragaie.training_app.sessions.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kerollosragaie.training_app.sessions.data.models.SocialPost
import com.kerollosragaie.training_app.sessions.data.models.TrainingSery
import com.kerollosragaie.training_app.sessions.data.repos.TrainingSeriesRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val trainingSeriesRepoImpl: TrainingSeriesRepoImpl) :
    ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    private val _trainingSeries by lazy { MutableStateFlow<List<TrainingSery>?>(null) }
    val trainingSeries: StateFlow<List<TrainingSery>?> by lazy { _trainingSeries }

    private val _socialPosts by lazy { MutableStateFlow<List<SocialPost>?>(null) }
    val socialPosts: StateFlow<List<SocialPost>?> by lazy { _socialPosts }

    init {
        viewModelScope.launch {
            try {
               val trainingSeries = trainingSeriesRepoImpl.getTrainingSeries()
                _trainingSeries.value = trainingSeries.trainingSeries
                _socialPosts.value = trainingSeries.socialPosts
                Log.d(TAG, "TrainingSeries: $_trainingSeries")
                Log.d(TAG, "SocialPosts: $_socialPosts")
            } catch (e: Exception) {
                Log.e(TAG, "Error: ${e.message.toString()}")
            }
        }
    }
}