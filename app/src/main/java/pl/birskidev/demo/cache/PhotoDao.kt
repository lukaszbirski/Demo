package pl.birskidev.demo.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.birskidev.demo.cache.model.PhotoEntity

@Dao
interface PhotoDao {
    @Insert
    suspend fun insertPhoto(photo: PhotoEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhotos(recipes: List<PhotoEntity>): LongArray

    @Query("SELECT * FROM photos WHERE id = :id")
    suspend fun getPhotoById(id: Int): PhotoEntity?

    @Query("SELECT * FROM photos")
    suspend fun getPhotos(): List<PhotoEntity>

    @Query("DELETE FROM photos WHERE id IN (:ids)")
    suspend fun deletePhotos(ids: List<Int>): Int

    @Query("DELETE FROM photos")
    suspend fun deleteAllPhotos()

    @Query("DELETE FROM photos WHERE id = :primaryKey")
    suspend fun deletePhoto(primaryKey: Int): Int
}
