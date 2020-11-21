package io.github.mohamedisoliman.nytopstories.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

@Database(entities = [Story::class], version = 1, exportSchema = false)
abstract class TopStoriesDatabase : RoomDatabase() {

    abstract fun topStoriesDao(): TopStoriesDao

}