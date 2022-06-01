package com.parzidev.adventure.model

import android.graphics.drawable.Drawable

object LivroDataObject {
    var livroListData = mutableListOf<LivroDataClass>()

    fun setData(nomeLivro: String, nomeAutor: String, foto: Drawable, numerosPaginaTotal: Int) {
        livroListData.add(LivroDataClass(nomeLivro, nomeAutor, foto, numerosPaginaTotal))
    }

    fun getAllData() : List<LivroDataClass>{
        return livroListData
    }
}