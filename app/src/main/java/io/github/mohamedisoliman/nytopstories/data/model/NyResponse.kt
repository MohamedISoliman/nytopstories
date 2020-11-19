package io.github.mohamedisoliman.nytopstories.data.model

data class NyResponse(
    val copyright: String? = "",
    val last_updated: String? = "",
    val num_results: Int? = 0,
    val results: List<Result>? = listOf(),
    val section: String? = "",
    val status: String? = ""
)