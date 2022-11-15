package com.example.pollaulimafinal.screens.main.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.pollaulimafinal.models.entity.Team
import com.example.pollaulimafinal.models.entity.TeamsDto
import androidx.compose.foundation.lazy.items

@Composable
fun ListaTeams(
    lista : List<TeamsDto>
){
    LazyColumn{
        items(lista){ lista ->
            Text(text = lista.name)
        }
    }
}