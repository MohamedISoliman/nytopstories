package io.github.mohamedisoliman.nytopstories.ui.home

import androidx.lifecycle.*
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.di.Dependencies
import io.github.mohamedisoliman.nytopstories.domain.BookmarkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import okhttp3.internal.notifyAll
import timber.log.Timber

class HomeViewModel : ViewModel() {

    private val retriever = Dependencies.topStoriesRetriever
    private val bookMarksHandler by lazy { Dependencies.bookMarksHandler }

    private val topStories = MutableLiveData<List<Story>>()
    fun topStories() = topStories

    private val errorsOrInfo = MutableLiveData<String>()
    fun errors() = errorsOrInfo

    private val loading = MutableLiveData<Boolean>()
    fun loading() = loading

    init {
        retriever.retrieve()
            .flowOn(Dispatchers.IO)
            .onStart { loading.postValue(true) }
            .onEach {
                if (it.isSuccess) {
                    topStories.postValue(it.getOrNull())
                } else {
                    Timber.e(it.exceptionOrNull())
                    errorsOrInfo.postValue(it.exceptionOrNull()?.message)
                }
            }.onEach { loading.postValue(false) }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }


    fun onBookmarkClicked(it: Story) {
        bookMarksHandler.handleBookmark(it)
            .flowOn(Dispatchers.IO)
            .onEach {
                Timber.d(when (it) {
                    BookmarkResult.Saved -> "Saved!"
                    BookmarkResult.FailedDeleting, BookmarkResult.FailedSaving -> "Something wrong happened!"
                    BookmarkResult.Deleted -> "Removed From bookmarks!"
                    BookmarkResult.IDLE -> ""
                })
            }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }


}