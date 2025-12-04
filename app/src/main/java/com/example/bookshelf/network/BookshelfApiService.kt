package com.example.bookshelf.networkimport kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

interface BookshelfApiService {
    // Define the endpoint to search for books
    // "volumes" is the endpoint for Google Books API
    @GET("volumes")
    suspend fun bookSearch(
        @Query("q") searchQuery: String
    ): BookResponse
}

// Data classes to parse the JSON response
@Serializable
data class BookResponse(
    val items: List<BookItem>? = null
)

@Serializable
data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo?
)

@Serializable
data class VolumeInfo(
    val title: String? = null,
    val authors: List<String>? = null,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(
    val thumbnail: String? = null
)
