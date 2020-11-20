package io.github.mohamedisoliman.nytopstories.di

import io.github.mohamedisoliman.nytopstories.data.NyTimesRepository
import io.github.mohamedisoliman.nytopstories.data.NyTimesRepositoryContract
import io.github.mohamedisoliman.nytopstories.data.remote.RemotesDataFactory
import io.github.mohamedisoliman.nytopstories.domain.TopStoriesRetriever

object Dependencies {


    val nyTimesRepository: NyTimesRepositoryContract =
        NyTimesRepository(RemotesDataFactory.nytApis())

    val topStoriesRetriever: TopStoriesRetriever =
        TopStoriesRetriever(nyTimesRepository)

}