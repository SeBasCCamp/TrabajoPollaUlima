package com.example.pollaulimafinal.models.remote

import androidx.compose.runtime.mutableStateListOf
import com.example.pollaulimafinal.models.entity.TeamsDto
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HTTPManager{
    private val teamsService : TeamsService
    private val ListaEquipos = mutableListOf<TeamsDto>()

    init{
        //Iniciar objeto retrfit
        //https://api.football-data.org/v4/competitions/WC/teams
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.football-data.org/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        teamsService = retrofit.create(TeamsService::class.java)
    }

    companion object {
        private var _instance: HTTPManager? = null
        val instance : HTTPManager
            get(){
                if(_instance==null){
                    _instance = HTTPManager()
                }
                return _instance!!
            }
    }

    fun getTeams() : List<TeamsDto>?{
        val obj = teamsService.getTeams().execute().body()
        var array = obj?.getAsJsonArray("teams")

        array?.forEach(){
            val obj = it.asJsonObject
            val name = obj.get("name").asString
            val founded = obj.get("founded").asInt
            val svg = obj.get("crest").toString()
            ListaEquipos.add(TeamsDto(svg,name,founded))
        }

        return ListaEquipos
    }
}


