package io.github.mohamedisoliman.nytopstories.ui.home

import androidx.lifecycle.*
import io.github.mohamedisoliman.nytopstories.data.model.NyTimesResponse
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.data.remote.RemotesDataFactory
import io.github.mohamedisoliman.nytopstories.di.Dependencies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel : ViewModel() {

    private val retriever = Dependencies.topStoriesRetriever

    private val topStories = MutableLiveData<List<Story>>()
    fun topStories() = topStories

    private val errors = MutableLiveData<String>()
    fun errors() = errors

    private val loading = MutableLiveData<Boolean>()
    fun loading() = loading


    fun save(it: Story) {

    }

    fun delete(it: Story) {

    }

    fun start() {
        retriever.retrieve()
            .onStart { loading.postValue(true) }
            .onEach {
                loading.postValue(false)
                if (it.isSuccess) {
                    topStories.postValue(it.getOrNull())
                } else {
                    Timber.e(it.exceptionOrNull())
                    errors.postValue(it.exceptionOrNull()?.message)
                }
            }
            .launchIn(viewModelScope)

    }

}