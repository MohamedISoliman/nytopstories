package io.github.mohamedisoliman.nytopstories.data.local

import io.github.mohamedisoliman.nytopstories.data.model.Story

interface LocalNyTimesContract {

    suspend fun retrieveBookmarks(): List<Story>

    suspend fun retrieveBookmark(title: String): Story?

    suspend fun bookmark(story: Story): Int?

    suspend fun deleteBookmark(title: String): Int
}