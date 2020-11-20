package io.github.mohamedisoliman.nytopstories.ui.main.home

import androidx.lifecycle.*
import io.github.mohamedisoliman.nytopstories.data.model.NyTimesResponse
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.data.remote.RemotesDataFactory
import io.github.mohamedisoliman.nytopstories.di.Dependencies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val retriever = Dependencies.topStoriesRetriever

    private val topStories = MutableLiveData<List<Story>>()
    fun topStories() = topStories

    private val errors = MutableLiveData<String>()
    fun errors() = errors

    private val loading = MutableLiveData<Boolean>()
    fun loading() = loading

    init {
        retriever.retrieve()
            .onStart { loading.postValue(true) }
            .onEach {
                if (it.isSuccess) {
                    topStories.postValue(it.getOrNull())
                }
                if (it.isFailure) {
                    errors.postValue(it.exceptionOrNull()?.message)
                }
            }
            .onStart { loading.postValue(false) }
            .launchIn(viewModelScope)
    }

}