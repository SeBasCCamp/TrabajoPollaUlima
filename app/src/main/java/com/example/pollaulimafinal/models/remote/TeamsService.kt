package com.example.pollaulimafinal.models.remote

import com.google.gson.JsonObject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface TeamsService {

    @Headers("X-Auth-Token: 7742a82517a748149352dc40444a89f5")
    @GET("/competitions/WC/teams")
    fun getTeams() : Call<JsonObject>
}