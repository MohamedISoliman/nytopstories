package io.github.mohamedisoliman.nytopstories.domain

import io.github.mohamedisoliman.nytopstories.data.local.LocalNyTimesContract
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.domain.BookmarkResult.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookMarksHandler(private val localData: LocalNyTimesContract) {


    fun handleBookmark(story: Story): Flow<BookmarkResult> {
        return flow {
            story.title?.let { title ->
                val retrieveBookmark = localData.retrieveBookmark(title)
                if (retrieveBookmark != null) {
                    val deleteBookmark = localData.deleteBookmark(title)
                    emit(
                        if (deleteBookmark == 0) FailedDeleting else Deleted
                    )
                } else {
                    val bookmark = localData.bookmark(story)
                    emit(if (bookmark == null) FailedSaving else Saved)
                }
            } ?: IDLE
        }


    }
}

sealed class BookmarkResult {
    object Saved : BookmarkResult()
    object FailedSaving : BookmarkResult()
    object Deleted : BookmarkResult()
    object FailedDeleting : BookmarkResult()
    object IDLE : BookmarkResult()

}