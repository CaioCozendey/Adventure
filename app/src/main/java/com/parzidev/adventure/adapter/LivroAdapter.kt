package com.parzidev.adventure.adapter

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.parzidev.adventure.LivroInformacoesActivity
import com.parzidev.adventure.MainActivity
import com.parzidev.adventure.model.LivroDataClass
import com.parzidev.adventure.R
import com.parzidev.adventure.fragment.BibliotecaFragment
import kotlinx.android.synthetic.main.activity_livro_informacoes.view.*
import kotlinx.android.synthetic.main.adapter_livro.view.*
import org.w3c.dom.Text

class LivroAdapter (private val listaDeLivro: ArrayList<LivroDataClass>)
    : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>(){

    class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nomeLivro: TextView = itemView.nome_livro
        var nomeAutor: TextView = itemView.nome_autor
        var foto: ImageView = itemView.imagem_livro
        var progressBar: ProgressBar = itemView.progress_bar
        var listLivroLayout: ConstraintLayout = itemView.livroLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val livroView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_livro, parent, false)
        return LivroViewHolder(livroView)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        holder.nomeLivro.text = listaDeLivro[position].nomeLivro
        holder.nomeAutor.text = listaDeLivro[position].nomeAutor
        holder.foto.setImageDrawable(listaDeLivro[position].foto)
        holder.progressBar.max = listaDeLivro[position].numeroPaginasTotal
        holder.progressBar.progress = listaDeLivro[position].paginaAtual
        holder.listLivroLayout.setOnClickListener{
            val intent = Intent(holder.itemView.context, BibliotecaFragment::class.java)
            intent.putExtra("Livro_ID", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listaDeLivro.size
    }
}