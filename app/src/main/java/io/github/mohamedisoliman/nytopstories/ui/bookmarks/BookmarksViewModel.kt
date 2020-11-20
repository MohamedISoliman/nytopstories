package io.github.mohamedisoliman.nytopstories.ui.bookmarks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.mohamedisoliman.nytopstories.data.model.Story

class BookmarksViewModel : ViewModel() {
    fun errors(): LiveData<String> {
        TODO()
    }

    fun loading(): LiveData<Boolean> {
        TODO()

    }

    fun bookmarks(): LiveData<List<Story>> {
        TODO()
    }

    fun start() {

    }

}