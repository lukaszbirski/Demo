package pl.birskidev.demo.repository.mapper

import pl.birskidev.demo.domain.Photo
import pl.birskidev.demo.network.model.MediaResponse
import pl.birskidev.demo.network.model.PhotoResponse

fun PhotoResponse.toDomain() = Photo(
    title = this.title,
    link = this.link,
    description = this.description,
    published = this.published,
    imageUrl = this.media.toDomain()
)

fun MediaResponse.toDomain() = this.imageUrl
