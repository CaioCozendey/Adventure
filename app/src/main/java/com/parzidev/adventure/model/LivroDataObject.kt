package com.parzidev.adventure.model

import android.graphics.drawable.Drawable
import com.parzidev.adventure.model.LivroDataClass as LivroDataClass1

object LivroDataObject {
    var livroListData = mutableListOf<LivroDataClass1>()

    fun setData(nomeLivro: String, nomeAutor: String, foto: Drawable, numerosPaginaTotal: Int, paginaAtual: Int) {
        livroListData.add(LivroDataClass1(nomeLivro, nomeAutor, foto, numerosPaginaTotal, paginaAtual))
    }

    fun getAllData() : List<LivroDataClass1>{
        return livroListData
    }
}