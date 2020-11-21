package io.github.mohamedisoliman.nytopstories.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.mohamedisoliman.nytopstories.data.NyTimesRepository
import io.github.mohamedisoliman.nytopstories.data.NyTimesRepositoryContract
import io.github.mohamedisoliman.nytopstories.data.local.LocalNyTimes
import io.github.mohamedisoliman.nytopstories.data.local.LocalNyTimesContract
import io.github.mohamedisoliman.nytopstories.data.local.TopStoriesDao
import io.github.mohamedisoliman.nytopstories.data.local.TopStoriesDatabase
import io.github.mohamedisoliman.nytopstories.data.remote.RemotesDataFactory
import io.github.mohamedisoliman.nytopstories.domain.BookMarksHandler
import io.github.mohamedisoliman.nytopstories.domain.TopStoriesRetriever

object Dependencies {


    private lateinit var localData: LocalNyTimesContract
    private lateinit var roomDb: TopStoriesDatabase
    lateinit var bookMarksHandler: BookMarksHandler
    private lateinit var nyTimesRepository: NyTimesRepositoryContract
    lateinit var topStoriesRetriever: TopStoriesRetriever

    fun init(context: Context) {
        roomDb = Room.databaseBuilder(context, TopStoriesDatabase::class.java, "androiddev.db")
            .fallbackToDestructiveMigration()
            .build()

        localData = LocalNyTimes(roomDb)
        bookMarksHandler = BookMarksHandler(localData)
        nyTimesRepository = NyTimesRepository(RemotesDataFactory.nytApis(), localData)
        topStoriesRetriever = TopStoriesRetriever(nyTimesRepository)
    }


}