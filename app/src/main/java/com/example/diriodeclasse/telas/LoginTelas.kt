package com.example.diriodeclasse.telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.diriodeclasse.R
import com.example.diriodeclasse.telas.telalogin.telaListaDeAlunos.TelaoriginVersionMode

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun LoginTelas(controledenavegacao: NavHostController,
               telaoriginVersionMode:TelaoriginVersionMode= viewModel()
){

    Card() {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(30.dp)
        )
        {

            Text(text = "Entrar",
            modifier = Modifier.height(40.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.i1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = telaoriginVersionMode.login,
                onValueChange = { telaoriginVersionMode.updatelogin(it)},
                label = { Text(text = "Login") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = telaoriginVersionMode.senha,
                onValueChange = { telaoriginVersionMode.updatesenha(it)},
                label = { Text(text = "Senha") }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button (
                onClick = { controledenavegacao.navigate("Telalistadealunos")
                }
            ){

                Text(text = "Entrar")
            }

        }
    }
}
