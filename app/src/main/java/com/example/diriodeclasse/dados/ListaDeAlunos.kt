package com.example.diriodeclasse.dados

import model.Aluno

class ListaDeAlunos {
    fun carregarlistadealunos():List<Aluno>{

        return listOf<Aluno>(
            Aluno("Giovanna","Direito"),
            Aluno("Rodrigo","Moda"),
            Aluno("Pedro","Adm"),
            Aluno("Anna","Cozinha"),
            Aluno("Rafael","Rh"),
            Aluno("Gregore","Design"),
            Aluno("Gian","Ed fisica"),
            Aluno("Aline","Direito"),

        )

    }

}