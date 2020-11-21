package io.github.mohamedisoliman.nytopstories.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.mohamedisoliman.nytopstories.data.model.Story
import kotlinx.coroutines.flow.Flow


@Dao
interface TopStoriesDao {

    @Query("SELECT * FROM story")
    suspend fun bookmarks(): List<Story>

    @Query("SELECT * FROM story")
    fun bookmarksFlow(): Flow<List<Story>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStory(story: Story): Long

    @Query("DELETE FROM story WHERE title = :title")
    suspend fun deleteStory(title: String): Int

    @Query("SELECT * FROM story WHERE title = :title")
    suspend fun retrieveStory(title: String): Story?
}