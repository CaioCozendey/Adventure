package com.parzidev.adventure

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.parzidev.adventure.adapter.LivroAdapter

class CriandoLivroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criando_livro)
        supportActionBar?.hide()

        //Inputs
        val inputNomeLivro = findViewById<EditText>(R.id.edit_text_nome_livro)
        val inputNomeAutor = findViewById<EditText>(R.id.edit_text_nome_autor)
        val inputNumeroPaginas = findViewById<EditText>(R.id.edit_text_total_paginas)
        //Button Criar
        val buttonInputImagemLivro = findViewById<ImageButton>(R.id.inputImageLivro)
        val buttonCriar = findViewById<Button>(R.id.button_criar)

        buttonCriar.setOnClickListener {
            inputNomeLivro.text.toString()


        }


    }
}