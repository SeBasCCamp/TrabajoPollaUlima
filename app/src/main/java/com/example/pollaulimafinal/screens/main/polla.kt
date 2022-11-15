package com.example.pollaulimafinal.screens.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.pollaulimafinal.models.entity.TeamsDto

@Composable
fun polla(
        lista : List<TeamsDto>
    ){
        LazyColumn{
            items(lista){ lista ->
                Text(text = lista.name)
            }
        }
    }
