package com.example.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.BaseViewModel
import com.example.data.Repository
import com.example.mapper.joke.ChuckNorrisJokeToChuckNorrisJokeUiMapper
import com.example.model.joke.ChuckNorrisJokeUi

class HomeViewModel(application: Application, repository: Repository) : BaseViewModel(application, repository) {

    val chuckNorrisJokeUi: LiveData<ChuckNorrisJokeUi> = MutableLiveData()

    fun start() {
        loadNextChuckNorrisJoke()
    }

    fun onNextClicked() {
        loadNextChuckNorrisJoke()
    }

    private fun loadNextChuckNorrisJoke() {
        repository.getRandomJokeAsync { result ->
            result.data?.let { joke ->
                chuckNorrisJokeUi.setValue(ChuckNorrisJokeToChuckNorrisJokeUiMapper().map(joke))
            }
        }
    }
}