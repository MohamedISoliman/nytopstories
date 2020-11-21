package io.github.mohamedisoliman.nytopstories.domain

import io.github.mohamedisoliman.nytopstories.data.NyTimesRepositoryContract
import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.*
import timber.log.Timber

class TopStoriesRetriever(
    private val repositoryContract: NyTimesRepositoryContract,
) {

    fun retrieve(): Flow<Result<List<Story>>> {
        return repositoryContract.retrieveTopStories()
            .map { list -> Result.success(list.distinctBy { it.title }) }
            .catch { emit(Result.failure(it)) }
    }


    fun retrieveBookmarks(): Flow<List<Story>> =
        repositoryContract.retrieveBookmarks()

}