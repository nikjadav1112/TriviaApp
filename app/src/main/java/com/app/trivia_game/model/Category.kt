package com.app.trivia_game.model


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("clues_count")
    val cluesCount: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String
)