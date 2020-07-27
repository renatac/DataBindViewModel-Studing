package com.example.databindingviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var number = 1

    //Disponibilizo as variáveis do xml como forma de livedata
    //Não uso mais os observables fields
    //Não quero expor meu MutableLivedata pra quem tá fora do viewModel:
    //back and field do kotlin - boa prática
    private val _counter = MutableLiveData<String>()
    val counter : LiveData<String>
        get() = _counter  //quem chama não consegue setar, logo o programa
    //não sofre efeitos colaterais

    init {
        _counter.value = number.toString()
    }

    fun clickMe(){
       _counter.value = (++number).toString() //incremento primeiro o valor do number pra só dps passar para _counter
    }
}