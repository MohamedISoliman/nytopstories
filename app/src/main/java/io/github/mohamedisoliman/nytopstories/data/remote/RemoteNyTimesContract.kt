package io.github.mohamedisoliman.nytopstories.data.remote

import io.github.mohamedisoliman.nytopstories.data.model.NyTimesResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface RemoteNyTimesContract {

    @GET("topstories/v2/home.json")
    suspend fun retrieveTopStories(): NyTimesResponse

}