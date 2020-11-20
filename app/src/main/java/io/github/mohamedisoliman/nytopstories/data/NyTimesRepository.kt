package io.github.mohamedisoliman.nytopstories.data

import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.data.remote.RemoteNyTimesContract

class NyTimesRepository(
    private val remoteNyTimesContract: RemoteNyTimesContract,
) : NyTimesRepositoryContract {


    override suspend fun retrieveTopStories(): List<Story> {
        val retrieveTopStories = remoteNyTimesContract.retrieveTopStories()
        return retrieveTopStories.stories ?: throw NullPointerException("Stories are null")
    }


}