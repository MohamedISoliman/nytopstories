package io.github.mohamedisoliman.nytopstories.data.local

import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.Flow

interface LocalNyTimesContract {

    suspend fun retrieveBookmarks(): List<Story>

    fun bookmarksFlow(): Flow<List<Story>>

    suspend fun retrieveBookmark(title: String): Story?

    suspend fun bookmark(story: Story): Int?

    suspend fun deleteBookmark(title: String): Int
}