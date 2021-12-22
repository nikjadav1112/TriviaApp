package com.app.trivia_game.model


import com.google.gson.annotations.SerializedName

data class MainModelItem(
    @SerializedName("airdate")
    val airdate: String,
    @SerializedName("answer")
    val answer: String,
    @SerializedName("category")
    val category: Category,
    @SerializedName("category_id")
    val categoryId: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("game_id")
    val gameId: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("invalid_count")
    val invalidCount: Any,
    @SerializedName("question")
    val question: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("value")
    val value: Int
)