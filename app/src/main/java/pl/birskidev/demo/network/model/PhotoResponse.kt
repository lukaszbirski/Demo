package pl.birskidev.demo.network.model

import com.google.gson.annotations.SerializedName
import java.util.Date

// todo @lukasz needs fixing
data class PhotoResponse(
    @SerializedName("title") val title: String,
    @SerializedName("link") val link: String,
    @SerializedName("description") val description: String,
    @SerializedName("published") val published: Date,
)

// data class Item(
//    val title: String,
//    val link: String,
//    val media: Media,
//    @SerializedName("date_taken") val dateTaken: String,
//    val description: String,
//    val published: String,
//    val author: String,
//    @SerializedName("author_id") val authorId: String,
//    val tags: String
// )

// data class Media(
//    @SerializedName("m") val imageUrl: String
// )
