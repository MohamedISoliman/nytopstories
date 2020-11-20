package io.github.mohamedisoliman.nytopstories.data

import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.Flow

interface NyTimesRepositoryContract {

    suspend fun retrieveTopStories(): List<Story>

}