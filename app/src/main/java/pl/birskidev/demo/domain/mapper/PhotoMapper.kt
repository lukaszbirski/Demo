package pl.birskidev.demo.domain.mapper

import pl.birskidev.demo.cache.model.PhotoEntity
import pl.birskidev.demo.domain.Photo
import pl.birskidev.demo.network.model.MediaResponse
import pl.birskidev.demo.network.model.PhotoResponse
import java.util.Date

fun PhotoResponse.toDomain() = Photo(
    link = this.link,
    description = this.description,
    published = this.published,
    imageUrl = this.media.toDomain()
)

fun MediaResponse.toDomain() = this.imageUrl

fun Photo.toEntity() = PhotoEntity(
    id = 0,
    link = this.link,
    description = this.description,
    published = this.published.time,
    imageUrl = this.imageUrl
)

fun PhotoEntity.toDomain() = Photo(
    link = this.link,
    description = this.description,
    published = Date(this.published),
    imageUrl = this.imageUrl
)
