package com.parzidev.adventure

data class Livro(
    val nomeLivro: String,
    val nomeAutor: String,
    val foto: String,
    val numeroPaginasTotal: Int,
    val primeiraPagina: Int = 1,
    val paginaAtual: Int = 1,
    val favorito: Boolean = false
    )


