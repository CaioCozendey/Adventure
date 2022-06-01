package com.parzidev.adventure.model

import android.graphics.drawable.Drawable

data class LivroDataClass(
    val nomeLivro: String,
    val nomeAutor: String,
    val foto: Drawable,
    val numeroPaginasTotal: Int,
    val paginaAtual: Int = 1,
    val primeiraPagina: Int = 1,
    val favorito: Boolean = false,
    val concluido: Boolean = false
    )



