package io.github.mohamedisoliman.nytopstories.data

import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.data.remote.RemoteNyTimesContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class NyTimesRepository(
    private val remoteNyTimesContract: RemoteNyTimesContract,
) : NyTimesRepositoryContract {


    override suspend fun retrieveTopStories(): Flow<List<Story>> {
        return flowOf(remoteNyTimesContract.retrieveTopStories())
            .map { it.stories ?: emptyList() }

    }


}