package io.github.mohamedisoliman.nytopstories.domain

import io.github.mohamedisoliman.nytopstories.data.NyTimesRepositoryContract
import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class TopStoriesRetriever(
    private val repositoryContract: NyTimesRepositoryContract,
) {


    suspend fun retrieve(): Flow<Result<List<Story>>> {
        return repositoryContract.retrieveTopStories()
            .map { Result.success(it) }
            .catch { emit(Result.failure(it)) }
    }

}