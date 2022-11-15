package com.example.pollaulimafinal.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pollaulimafinal.models.entity.Team
import com.example.pollaulimafinal.models.entity.TeamsDto
import com.example.pollaulimafinal.models.remote.HTTPManager
import com.example.pollaulimafinal.screens.main.components.ListaTeams
import com.example.pollaulimafinal.screens.main.logIn.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun MainScreen(
){
    val navController = rememberNavController()
    val listaFinal = remember{
        mutableStateListOf<TeamsDto>()
    }
    LaunchedEffect(key1 = true){

        val listaCorrutine = withContext(Dispatchers.IO){
            HTTPManager.instance.getTeams()
        }
        if(listaCorrutine != null){
            listaCorrutine.forEach{
                listaFinal.add(it)
            }
        }else{
            Log.e("MainScreen","Error de comunicacion con el servicio")
        }
    }
    ListaTeams(lista = listaFinal)

    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.navigate(Screen.MainScreen.route) },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(text = "Login")
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.navigate(Screen.polla.route) },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(text = "Login")
        }
    }

}
