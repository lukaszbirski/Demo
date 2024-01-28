package pl.birskidev.demo.network.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class PhotoResponse(
    @SerializedName("title") val title: String,
    @SerializedName("link") val link: String,
    @SerializedName("media") val media: MediaResponse,
    @SerializedName("date_taken") val dateTaken: String,
    @SerializedName("description") val description: String,
    @SerializedName("published") val published: Date,
    @SerializedName("author") val author: String,
    @SerializedName("author_id") val authorId: String,
    @SerializedName("tags") val tags: String,
)

data class MediaResponse(
    @SerializedName("m") val imageUrl: String
)
