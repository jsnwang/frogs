package com.moo.frogs.model

import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {

    @GET("r/<subreddit>/search.json")
    suspend fun getListings(
        @Query("q") query: String = "frog",
        @Query("restrict_sr") restrict_sr: String = "on",
        @Query("t") time: String = "all",
        @Query("limit") limit: Int = 100,
    )
}