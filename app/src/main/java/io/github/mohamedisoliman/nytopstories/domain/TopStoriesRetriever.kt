package io.github.mohamedisoliman.nytopstories.domain

import io.github.mohamedisoliman.nytopstories.data.NyTimesRepositoryContract
import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.*

class TopStoriesRetriever(
    private val repositoryContract: NyTimesRepositoryContract,
) {


    fun retrieve(): Flow<Result<List<Story>>> {
        return flow { emit(repositoryContract.retrieveTopStories()) }
            .map { Result.success(it) }
            .catch { emit(Result.failure(it)) }
    }

}