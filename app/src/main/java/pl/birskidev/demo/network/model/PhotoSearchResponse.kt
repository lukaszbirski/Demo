package pl.birskidev.demo.network.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class PhotoSearchResponse(
    @SerializedName("title") val title: String,
    @SerializedName("link") val link: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: Date,
    @SerializedName("generator") val generator: String,
    @SerializedName("items") val items: List<PhotoResponse>,
)
