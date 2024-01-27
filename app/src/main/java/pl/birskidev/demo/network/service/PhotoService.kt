package pl.birskidev.demo.network.service

import pl.birskidev.demo.network.model.PhotoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {
    @GET("photos_public.gne")
    suspend fun search(
        @Query("format") format: String,
        @Query("tags") tags: String,
        @Query("nojsoncallback") nojsoncallback: Int,
    ): PhotoSearchResponse
}
