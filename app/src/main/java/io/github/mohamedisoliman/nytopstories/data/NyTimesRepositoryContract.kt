package io.github.mohamedisoliman.nytopstories.data

import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.Flow

interface NyTimesRepositoryContract {

    fun retrieveTopStories(): Flow<List<Story>>

    fun retrieveBookmarks(): Flow<List<Story>>

}