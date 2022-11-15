package com.example.pollaulimafinal.screens.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.pollaulimafinal.models.entity.Team
import com.example.pollaulimafinal.models.entity.TeamsDto
import com.example.pollaulimafinal.models.remote.HTTPManager
import com.example.pollaulimafinal.screens.main.components.ListaTeams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun detailScreen(
){
    val navController = rememberNavController()
    val listaFin = remember{
        mutableStateListOf<Team>()
    }
    LaunchedEffect(key1 = true){

        val listaD = withContext(Dispatchers.IO){
            HTTPManager.instance.getTeams()
        }
        if(listaD != null){
            listaD.forEach{
                listaFin.add(it)
            }
        }else{
            Log.e("MainScreen","Error de comunicacion con el servicio")
        }
    }
    ListaTeams(team = listaFin)
}


