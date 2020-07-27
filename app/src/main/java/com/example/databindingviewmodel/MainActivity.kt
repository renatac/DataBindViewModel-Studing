package com.example.databindingviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.databindingviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Forma mais fácil de criar um viewModel é utilizando uma extension de fragmento.
    //Obs: Importei no build.gradle:  implementation "androidx.fragment:fragment-ktx:1.2.4"
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Por causa do DataBaind não utilizo mais o método abaixo
        //  setContentView(R.layout.activity_main)
        //Inflando o layout
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
            )
        //conectando o viewModel com o xml
        binding.viewmodel = viewModel
        //permitir que o DataBinding trabalhe com o LiveData e respeite o ciclo de vida
        binding.lifecycleOwner = this //o dono do ciclo de vida é essa activity
    }
}
