package io.github.mohamedisoliman.nytopstories.ui.bookmarks

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.di.Dependencies

class BookmarksViewModel : ViewModel() {


    val bookMarksHandler by lazy { Dependencies.bookMarksHandler }

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