package com.parzidev.adventure

data class Livro(
    val nomeLivro: String,
    val nomeAutor: String,
    val foto: String,
    val numeroPaginasTotal: Int,
    val paginaAtual: Int = 1,
    val primeiraPagina: Int = 1,
    val favorito: Boolean = false,
    val concluido: Boolean = false
    )
{
    fun verificarProgresso(atual: String, total: String){
        if (atual == total){
            concluido to true
        }
    }
}


