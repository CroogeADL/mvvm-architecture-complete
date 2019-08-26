package com.example.common

import android.content.Context
import com.example.data.Repository
import com.example.data.RepositoryImpl
import com.example.data.datasource.network.NetworkDataSource
import com.example.data.joke.ChuckNorrisJokesRepository

class RepositoryProvider private constructor() {
    companion object {
        @Volatile
        private var INSTANCE: Repository? = null

        fun getRepository(context: Context): Repository {
            return INSTANCE ?: synchronized(this) {
                //todo use context for initialization another data sources like Shared Preferences, DB etc.
                val networkDataSource = NetworkDataSource()

                //todo init all repositories
                val chuckNorrisJokesRepository = ChuckNorrisJokesRepository(networkDataSource)

                INSTANCE ?: RepositoryImpl(chuckNorrisJokesRepository).also { INSTANCE = it }
            }
        }
    }
}
