package com.example.data.network.joke

import com.example.data.network.base.ResponseData
import com.example.model.joke.ChuckNorrisJokeResponse
import retrofit2.Call
import retrofit2.http.GET

private const val RANDOM_JOKE_PATH = "random"

interface ChuckNorrisJokesService {

    @GET(RANDOM_JOKE_PATH)
    fun getRandomJoke(): Call<ResponseData<ChuckNorrisJokeResponse>>
}