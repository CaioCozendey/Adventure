package com.parzidev.adventure.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.parzidev.adventure.model.LivroDataClass
import com.parzidev.adventure.R
import kotlinx.android.synthetic.main.adapter_livro.view.*

class LivroAdapter (private val listaDeLivro: ArrayList<LivroDataClass>) :
    RecyclerView.Adapter<LivroAdapter.LivroViewHolder>(){

    class LivroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val textViewNomeLivro : TextView = itemView.findViewById(R.id.nome_livro)
        private val textViewNomeAutor : TextView = itemView.findViewById(R.id.nome_autor)
        private val imageViewImagemLivro : ImageView = itemView.findViewById(R.id.imagem_livro)
        private val progressBar : ProgressBar = itemView.findViewById(R.id.progress_bar)
        //private val botaoFavotiro : ImageButton = itemView.findViewById(R.id.imageButton_coracao_favorito)


        fun populaAdapterCom(livro: LivroDataClass){
            textViewNomeLivro.text = livro.nomeLivro
            textViewNomeAutor.text = livro.nomeAutor
            Glide.with(itemView.context).load(livro.foto).into(imageViewImagemLivro)
            progressBar.max = livro.numeroPaginasTotal
            progressBar.progress = livro.paginaAtual
        }

        /*class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var nomeLivro: TextView = itemView.nome_livro
            var nomeAutor: TextView = itemView.nome_autor
        }*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_livro, parent, false)
        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        holder.populaAdapterCom(listaDeLivro[position])
    }

    override fun getItemCount(): Int {
        return listaDeLivro.size
    }
}