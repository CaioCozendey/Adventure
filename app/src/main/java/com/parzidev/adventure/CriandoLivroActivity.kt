package com.parzidev.adventure

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult


class CriandoLivroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criando_livro)
        supportActionBar?.hide()

        //Inputs
        val buttonInputImagemLivro = findViewById<ImageButton>(R.id.inputImageLivro)
        val inputNomeLivro = findViewById<EditText>(R.id.edit_text_nome_livro)
        val inputNomeAutor = findViewById<EditText>(R.id.edit_text_nome_autor)
        val inputNumeroPaginas = findViewById<EditText>(R.id.edit_text_total_paginas)
        //Button Criar
        val buttonCriar = findViewById<Button>(R.id.button_criar)

    }
}