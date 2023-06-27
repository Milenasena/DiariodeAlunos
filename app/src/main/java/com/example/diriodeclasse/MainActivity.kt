package com.example.diriodeclasse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diriodeclasse.telas.LoginTelas
import com.example.diriodeclasse.telas.Telalistadealunos
import com.example.diriodeclasse.ui.theme.DiárioDeClasseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiárioDeClasseTheme {
                  Telalistadealunos(controledenavegacao)
            }
        }
    }
}
@Composable
fun AppDiarioDeClasse(){
    //navegação da tela

    var controledenavegacao = rememberNavController()
    NavHost(
        navController = controledenavegacao,
        startDestination = "Telalogin"
    ){
        composable(
            route= "Telalogin"
        ){
            LoginTelas(controledenavegacao)
        }
        composable(
            route="TelalistaAlunos"
        ){
            Telalistadealunos(controledenavegacao)
        }
    }
}

    

