package io.github.mohamedisoliman.nytopstories.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Multimedia(
    @SerializedName("caption")
    val caption: String? = "",
    @SerializedName("copyright")
    val copyright: String? = "",
    @SerializedName("format")
    val format: String? = "",
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("subtype")
    val subtype: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("width")
    val width: Int? = 0,
) : Parcelable