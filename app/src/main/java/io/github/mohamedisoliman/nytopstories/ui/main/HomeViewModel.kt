package io.github.mohamedisoliman.nytopstories.ui.main

import androidx.lifecycle.*
import io.github.mohamedisoliman.nytopstories.data.model.NyTimesResponse
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.data.remote.RemotesDataFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val topStories = MutableLiveData<List<Story>>()
    fun topStories() = topStories

    private val errors = MutableLiveData<String>()
    fun errors() = errors

    private val loading = MutableLiveData<Boolean>()
    fun loading() = loading

    init {

        viewModelScope.launch {
            loading.postValue(true)
            try {
                val retrieveTopStories = RemotesDataFactory.nytApis().retrieveTopStories()
                topStories.postValue(retrieveTopStories.stories ?: emptyList())
            } catch (e: Exception) {
                errors.postValue("Something wrong happened!")
            } finally {
                loading.postValue(false)
            }
        }
    }

}