package justinkim.fetch.api

import retrofit2.http.GET

interface FetchApi {
    @GET("hiring.json")
    suspend fun fetchItems(): List<FetchItemDto>
}