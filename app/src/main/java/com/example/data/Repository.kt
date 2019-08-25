package com.example.data

import com.example.data.network.base.ResultData
import com.example.model.joke.ChuckNorrisJoke

interface Repository {
    fun getRandomJoke(): ResultData<ChuckNorrisJoke>
    fun getRandomJokeAsync(onResult: (resultData: ResultData<ChuckNorrisJoke>) -> Unit)
}