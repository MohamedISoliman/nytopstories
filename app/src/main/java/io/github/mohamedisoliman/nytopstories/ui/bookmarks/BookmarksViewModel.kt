package io.github.mohamedisoliman.nytopstories.ui.bookmarks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.di.Dependencies
import io.github.mohamedisoliman.nytopstories.domain.BookmarkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import timber.log.Timber

class BookmarksViewModel : ViewModel() {


    private val retriever = Dependencies.topStoriesRetriever
    private val bookMarksHandler by lazy { Dependencies.bookMarksHandler }

    private val topStories = MutableLiveData<List<Story>>()
    fun topStories() = topStories

    private val errorsOrInfo = MutableLiveData<String>()
    fun errors() = errorsOrInfo

    private val loading = MutableLiveData<Boolean>()
    fun loading() = loading

    init {
        retriever.retrieveBookmarks()
            .flowOn(Dispatchers.IO)
            .onStart { loading.postValue(true) }
            .onEach { topStories.postValue(it) }
            .onEach { loading.postValue(false) }
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