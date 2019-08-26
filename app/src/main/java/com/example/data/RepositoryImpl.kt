package com.example.data

import com.example.data.joke.RepositoryChuckNorrisJokes

class RepositoryImpl constructor(private val chuckNorrisJokesRepository: RepositoryChuckNorrisJokes) :
    Repository,
    RepositoryChuckNorrisJokes by chuckNorrisJokesRepository