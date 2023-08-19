package com.kerollosragaie.training_app.sessions.presentation.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kerollosragaie.training_app.databinding.ActivityMainBinding
import com.kerollosragaie.training_app.sessions.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fetchData()
    }

    private fun fetchData() {
        lifecycleScope.launch {
            mainViewModel.trainingSeries.collect { trainingSeries ->
                trainingSeries?.forEach { series ->
                    Log.d(TAG, "TrainingSeries: $series")
                }
            }


        }

        lifecycleScope.launch {
            mainViewModel.socialPosts.collect { socialPosts ->
                socialPosts?.forEach { post ->
                    Log.d(TAG, "SocialPosts: $post")
                }
            }
        }
    }
}
