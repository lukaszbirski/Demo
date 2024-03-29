package pl.birskidev.demo.domain

import java.util.Date

data class Photo(
    val link: String,
    val description: String,
    val published: Date,
    val imageUrl: String
)
