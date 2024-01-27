package pl.birskidev.demo.repository

import pl.birskidev.demo.domain.Photo

interface PhotoRepository {
    suspend fun search(
        format: String,
        tags: String,
        nojsoncallback: Int,
    ): List<Photo>
}
