package com.example.diriodeclasse.telas

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.diriodeclasse.dados.ListaDeAlunos
import model.Aluno

@Composable
fun Telalistadealunos(controledenavegacao: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),

        color = Color.White
    ) {
        LazyColumn {
            items(ListaDeAlunos().carregarlistadealunos()) { aluno ->
                CartaoAluno(aluno = aluno)
            }

        }

    }

}


@Composable
fun CartaoAluno(aluno: Aluno) {
    var expandir by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
                //para animar algum componente da tela
                .animateContentSize(
                    animationSpec = spring
                        (
                        dampingRatio = Spring.StiffnessLow,
                        stiffness = Spring.StiffnessMediumLow
                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = aluno.foto),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(11.dp))
                )

                Column() {
                    Text(text = aluno.nome)
                    Text(text = aluno.curso)

                }
                Spacer(modifier = Modifier.width(70.dp))
                //Ele expande as notificações no celular
                Icon(
                    imageVector = if (expandir == true)
                    //A seta para mostrar o que não está expandido

                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    //Quando clicar no botão ele vai expandir a tela
                    modifier = Modifier
                        .clickable { expandir = !expandir }
                )

            }
            if (expandir == true) {
                Spacer(modifier = Modifier.height(50.dp))
                //to string valor em inteiro
                Text(
                    text = "Faltas: ${aluno.faltas}"
                )
                Text(
                    text = "Nota ${aluno.nota}"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviwCardAluno() {
    CartaoAluno(
        aluno = Aluno(
            nome = "Milena",
            curso = "Design"

        )
    )
}

