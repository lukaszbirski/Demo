package pl.birskidev.demo.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.birskidev.demo.cache.model.PhotoEntity

@Database(entities = [PhotoEntity::class ], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun photoDao(): PhotoDao

    companion object{
        val DATABASE_NAME: String = "photo_db"
    }
}