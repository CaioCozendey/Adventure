package com.parzidev.adventure

data class Livro(
    val nomeLivro: String,
    val nomeAutor: String,
    val foto: String,
    val numeroPaginasTotal: Int,
    val primeiraPagina: Int,
    val paginaAtual: Int,
    val favorito: Boolean = false
    )


