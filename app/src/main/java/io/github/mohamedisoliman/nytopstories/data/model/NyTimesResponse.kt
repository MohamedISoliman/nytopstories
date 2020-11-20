package io.github.mohamedisoliman.nytopstories.data.model


import com.google.gson.annotations.SerializedName

data class NyTimesResponse(
    @SerializedName("copyright")
    val copyright: String? = "",
    @SerializedName("last_updated")
    val lastUpdated: String? = "",
    @SerializedName("num_results")
    val numResults: Int? = 0,
    @SerializedName("results")
    val stories: List<Story>? = listOf(),
    @SerializedName("section")
    val section: String? = "",
    @SerializedName("status")
    val status: String? = ""
)