package io.github.mohamedisoliman.nytopstories.data

import io.github.mohamedisoliman.nytopstories.data.local.LocalNyTimesContract
import io.github.mohamedisoliman.nytopstories.data.model.Story
import io.github.mohamedisoliman.nytopstories.data.remote.RemoteNyTimesContract
import kotlinx.coroutines.flow.*
import java.lang.NullPointerException

class NyTimesRepository(
    private val remoteNyTimesContract: RemoteNyTimesContract,
    private val localNyTimes: LocalNyTimesContract,
) : NyTimesRepositoryContract {


    override fun retrieveTopStories(): Flow<List<Story>> {
        return remoteFlow()
            .map {
                if (it.title != null) {
                    localNyTimes.retrieveBookmark(it.title!!) ?: it
                } else {
                    it
                }
            }.scan(emptyList()) { acc: List<Story>, product -> acc + product }

    }

    private fun remoteFlow(): Flow<Story> {
        return flow {
            val stories = remoteNyTimesContract.retrieveTopStoriesResponse().stories
                ?: throw NullPointerException()
            for (item in stories) emit(item)
        }
    }


    private fun localFlow(): Flow<Story> = retrieveBookmarks().flatMapConcat { it.asFlow() }

    override fun retrieveBookmarks(): Flow<List<Story>> = localNyTimes.bookmarksFlow()


}