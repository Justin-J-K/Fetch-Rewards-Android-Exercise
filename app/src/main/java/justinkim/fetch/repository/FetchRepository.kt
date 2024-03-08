package justinkim.fetch.repository

import justinkim.fetch.api.FetchApi
import justinkim.fetch.model.FetchItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val FETCH_API_URL = "https://fetch-hiring.s3.amazonaws.com/"

class FetchRepository {
    private val fetchApi: FetchApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(FETCH_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        fetchApi = retrofit.create()
    }

    suspend fun fetchSortedValidItems() = fetchApi.fetchItems()
        .filter { it.isValid() }
        .map { it.toEntity() }
        .sortedWith(
            compareBy<FetchItem> { it.listId }.thenBy { it.name }
        )

}