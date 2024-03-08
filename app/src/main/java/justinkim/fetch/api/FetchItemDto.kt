package justinkim.fetch.api

import com.google.gson.annotations.SerializedName
import justinkim.fetch.model.FetchItem

data class FetchItemDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String?
) {
    fun isValid() = !name.isNullOrBlank()
    fun toEntity() = FetchItem(id, listId, name ?: "")
}