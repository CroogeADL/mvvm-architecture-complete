package com.example.data

import com.example.data.network.NetworkDataSource
import com.example.data.network.base.ResultData
import com.example.model.joke.ChuckNorrisJoke

class RepositoryImpl constructor(private val networkDataSource: NetworkDataSource) : Repository {

    override fun getRandomJoke(): ResultData<ChuckNorrisJoke> =
        networkDataSource.chuckNorrisJokesModule().getRandomJoke()

    override fun getRandomJokeAsync(onResult: (resultData: ResultData<ChuckNorrisJoke>) -> Unit) =
        networkDataSource.chuckNorrisJokesModule().getRandomJokeAsync(onResult)
}