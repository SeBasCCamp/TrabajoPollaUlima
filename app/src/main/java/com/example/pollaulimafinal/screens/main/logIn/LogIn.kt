package com.example.pollaulimafinal.screens.main.logIn

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pollaulimafinal.ui.theme.Teal200
import dev.chrisbanes.accompanist.coil.CoilImage
import com.example.pollaulimafinal.R


@SuppressLint("UnrememberedMutableState")
@Composable
fun LogIn(
    navController: NavHostController
) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        val username = remember { mutableStateOf(TextFieldValue()) }

        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo Ulima")
        Spacer(modifier = Modifier.height(100.dp))


        Text(text = "Polla Ulima", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Default),
            textAlign = TextAlign.Center  )

        Spacer(modifier = Modifier.height(155.dp))


        Text(text = "20182456")
        Spacer(modifier = Modifier.height(15.dp))


        Text(text = "20190322")
        Spacer(modifier = Modifier.height(15.dp))


        TextField(
            value = username.value,
            onValueChange = { username.value = it }
        )

        usuario.nombre = username.value.text
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.route)
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(text = "Ingresar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    LogIn(navController = navController)
}