package com.example.common

import android.content.Context
import com.example.data.Repository
import com.example.data.RepositoryImpl
import com.example.data.network.NetworkDataSource

class RepositoryProvider private constructor() {
    companion object {
        @Volatile
        private var INSTANCE: Repository? = null

        fun getRepository(context: Context): Repository {
            return INSTANCE ?: synchronized(this) {
                //todo use context for initialization another data sources like Shared Preferences, DB etc.
                val networkDataSource = NetworkDataSource()

                INSTANCE ?: RepositoryImpl(networkDataSource).also { INSTANCE = it }
            }
        }
    }
}
