package pl.birskidev.demo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.birskidev.demo.cache.PhotoDao
import pl.birskidev.demo.repository.PhotoRepository
import pl.birskidev.demo.usecase.photo_list.GetPhotosUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Singleton
    @Provides
    fun provideGetPhotosUseCase(photoRepository: PhotoRepository, photoDao: PhotoDao): GetPhotosUseCase {
        return GetPhotosUseCase(photoRepository = photoRepository, photoDao = photoDao)
    }
}
