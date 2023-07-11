package com.example.diriodeclasse.telas.telalogin.telaListaDeAlunos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.diriodeclasse.telas.TelalogGIN.TelaLoginUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TelaoriginVersionMode :ViewModel(){

    private val _telaloginuistate = MutableStateFlow(TelaLoginUIState())
    val telaloginstate = StateFlow<TelaLoginUIState> =_telaloginuistate.asStateFlow()

    var login by mutableStateOf("")
    var senha by mutableStateOf("")

    fun updatelogin(login:String){
        this.login = login

    }
    fun updatesenha(login:String){
        this.senha = senha

    }

    fun loginusuario(){
        if(login.isEmpty() || senha.isEmpty()){
            return
        }
    }
}