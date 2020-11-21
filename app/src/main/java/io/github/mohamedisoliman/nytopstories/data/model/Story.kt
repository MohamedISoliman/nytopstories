package io.github.mohamedisoliman.nytopstories.data.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Story(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @SerializedName("abstract")
    var `abstract`: String? = "",
    @SerializedName("byline")
    var byline: String? = "",
    @SerializedName("created_date")
    var createdDate: String? = "",
    @SerializedName("des_facet")
    @Ignore
    var desFacet: List<String>? = listOf(),
    @SerializedName("geo_facet")
    @Ignore
    var geoFacet: List<String>? = listOf(),
    @SerializedName("item_type")
    var itemType: String? = "",
    @SerializedName("kicker")
    var kicker: String? = "",
    @SerializedName("material_type_facet")
    var materialTypeFacet: String? = "",
    @SerializedName("multimedia")
    @Ignore
    var multimedia: List<Multimedia>? = listOf(),
    @SerializedName("org_facet")
    @Ignore
    var orgFacet: List<String>? = listOf(),
    @SerializedName("per_facet")
    @Ignore
    var perFacet: List<String>? = listOf(),
    @SerializedName("published_date")
    var publishedDate: String? = "",
    @SerializedName("section")
    var section: String? = "",
    @SerializedName("short_url")
    var shortUrl: String? = "",
    @SerializedName("subsection")
    var subsection: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("updated_date")
    var updatedDate: String? = "",
    @SerializedName("uri")
    var uri: String? = "",
    @SerializedName("url")
    var url: String? = "",
) : Parcelable