package com.example.data.network.joke

import com.example.data.network.base.ResultData
import com.example.data.network.execute
import com.example.data.network.base.AbstractModule
import com.example.model.joke.ChuckNorrisJoke
import com.example.mapper.joker.ChuckNorrisJokeResponseToChuckNorrisJokeMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChuckNorrisJokesModule(service: ChuckNorrisJokesService) :
    AbstractModule<ChuckNorrisJokesService>(service),
    ModuleChuckNorrisJokes {

    override fun getRandomJoke(): ResultData<ChuckNorrisJoke> =
        getRandomJokeCall().execute(ChuckNorrisJokeResponseToChuckNorrisJokeMapper())

    override fun getRandomJokeAsync(onResult: (resultData: ResultData<ChuckNorrisJoke>) -> Unit) {
        launch {
            val response = withContext(Dispatchers.IO) {
                getRandomJokeCall().execute(ChuckNorrisJokeResponseToChuckNorrisJokeMapper())
            }
            onResult(response)
        }
    }

    private fun getRandomJokeCall() = service.getRandomJoke()
}