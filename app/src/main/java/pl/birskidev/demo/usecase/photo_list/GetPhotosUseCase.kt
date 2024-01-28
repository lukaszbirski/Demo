package pl.birskidev.demo.usecase.photo_list

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pl.birskidev.demo.cache.PhotoDao
import pl.birskidev.demo.domain.Photo
import pl.birskidev.demo.domain.data.DataState
import pl.birskidev.demo.domain.mapper.toEntity
import pl.birskidev.demo.repository.PhotoRepository

class GetPhotosUseCase(
    private val photoRepository: PhotoRepository,
    private val photoDao: PhotoDao
) {
    fun invoke(
        format: String,
        tags: String,
        nojsoncallback: Int
    ): Flow<DataState<List<Photo>>> = flow {
        try {
            emit(DataState.loading())

            val photos = photoRepository.search(
                format = format,
                tags = tags,
                nojsoncallback = nojsoncallback
            ).sortedBy { it.published.time }

            photoDao.insertPhotos(photos.map { it.toEntity() })

            emit(DataState.success(photos))
        } catch (e: Exception) {
            emit(DataState.error<List<Photo>>(e.message ?: "Error"))
        }
    }
}
