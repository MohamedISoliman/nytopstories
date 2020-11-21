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
        return flow {
            val stories = remoteNyTimesContract.retrieveTopStoriesResponse().stories
                ?: throw NullPointerException()
            for (item in stories) emit(item)
        }.map {
            if (it.title != null) {
                localNyTimes.retrieveBookmark(it.title!!) ?: it
            } else {
                it
            }
        }.scan(emptyList()) { acc: List<Story>, product -> acc + product }

    }

    suspend fun retrieveBookmarks(): List<Story> = localNyTimes.retrieveBookmarks()

    suspend fun bookmark(story: Story): Int? = localNyTimes.bookmark(story)

    suspend fun deleteBookmark(title: String) = localNyTimes.deleteBookmark(title)


}