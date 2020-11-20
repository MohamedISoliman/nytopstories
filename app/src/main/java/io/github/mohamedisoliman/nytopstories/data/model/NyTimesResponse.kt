package io.github.mohamedisoliman.nytopstories.data.model

data class NyTimesResponse(
    val copyright: String? = "",
    val last_updated: String? = "",
    val num_results: Int? = 0,
    val stories: List<Story>? = listOf(),
    val section: String? = "",
    val status: String? = ""
)