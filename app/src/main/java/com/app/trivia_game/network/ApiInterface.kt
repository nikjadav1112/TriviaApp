package com.app.trivia_game.network

import com.app.trivia_game.model.MainModelItem
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("random")
    fun getQuestion() : Call<List<MainModelItem>>
}