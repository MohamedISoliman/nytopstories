package io.github.mohamedisoliman.nytopstories.data

import io.github.mohamedisoliman.nytopstories.data.model.Story

interface NyTimesRepositoryContract {

    suspend fun retrieveTopStories(): List<Story>

}