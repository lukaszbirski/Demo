package pl.birskidev.demo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.birskidev.demo.network.service.PhotoService
import pl.birskidev.demo.repository.PhotoRepository
import pl.birskidev.demo.repository.PhotoRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providePhotoRepository(photoService: PhotoService) =
        PhotoRepositoryImpl(photoService = photoService) as PhotoRepository
}
