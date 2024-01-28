package pl.birskidev.demo.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "link") var link: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "published") var published: Long,
    @ColumnInfo(name = "imageUrl") var imageUrl: String,
)
