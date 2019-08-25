package com.example.mapper.joker

import com.example.model.joke.ChuckNorrisJoke
import com.example.model.joke.ChuckNorrisJokeResponse
import com.example.mapper.Mapper

class ChuckNorrisJokeResponseToChuckNorrisJokeMapper :
    Mapper<ChuckNorrisJokeResponse, ChuckNorrisJoke> {
    override fun map(model: ChuckNorrisJokeResponse) = ChuckNorrisJoke(model.joke)
}