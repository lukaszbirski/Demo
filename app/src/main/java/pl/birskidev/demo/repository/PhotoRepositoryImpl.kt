package pl.birskidev.demo.repository

import pl.birskidev.demo.network.service.PhotoService
import pl.birskidev.demo.domain.mapper.toDomain

class PhotoRepositoryImpl(
    private val photoService: PhotoService,
) : PhotoRepository {
    override suspend fun search(
        format: String,
        tags: String,
        nojsoncallback: Int
    ) = photoService.search(format = format, tags = tags, nojsoncallback = nojsoncallback).items.map { it.toDomain() }
}
