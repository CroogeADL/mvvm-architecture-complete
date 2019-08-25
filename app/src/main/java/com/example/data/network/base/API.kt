package com.example.data.network.base

import com.example.data.network.joke.ModuleChuckNorrisJokes

interface API {
    fun chuckNorrisJokesModule(): ModuleChuckNorrisJokes
}