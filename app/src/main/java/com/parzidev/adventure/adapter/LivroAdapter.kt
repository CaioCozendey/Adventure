package com.parzidev.adventure.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.parzidev.adventure.MainActivity
import com.parzidev.adventure.model.LivroDataClass
import com.parzidev.adventure.R
import kotlinx.android.synthetic.main.adapter_livro.view.*

class LivroAdapter (private val listaDeLivro: ArrayList<LivroDataClass>) :
    RecyclerView.Adapter<LivroAdapter.LivroViewHolder>(){

    class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nomeLivro: TextView = itemView.nome_livro
        var nomeAutor: TextView = itemView.nome_autor
        var foto: ImageView = itemView.imagem_livro
        var progressBar: ProgressBar = itemView.progress_bar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_livro, parent, false)
        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        holder.nomeLivro.text = listaDeLivro[position].nomeLivro
        holder.nomeAutor.text = listaDeLivro[position].nomeAutor
        holder.foto.setImageDrawable(listaDeLivro[position].foto)
        holder.progressBar.max = listaDeLivro[position].numeroPaginasTotal
        val intent = Intent(holder.itemView.context, MainActivity::class.java)
        intent.putExtra("ID", position)
        holder.itemView.context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return listaDeLivro.size
    }
}