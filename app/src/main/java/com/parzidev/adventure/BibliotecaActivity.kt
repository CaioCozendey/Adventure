package com.parzidev.adventure

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.model.Model
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.parzidev.adventure.adapter.LivroAdapter
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton as ExtendedFloatingActionButton1


class BibliotecaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)
        supportActionBar?.hide()

        //Início Lista

        val primeiraPagina = 1

        val livro1 = Livro("Trono de Vidro", "Sarah J Mass", "https://images-na.ssl-images-amazon.com/images/I/81sppP3MAkL.jpg", 450, primeiraPagina ,15)
        val livro2 = Livro("The Witcher", "Andrezj", "https://m.media-amazon.com/images/I/511dqSSiUCL._SY346_.jpg", 400, primeiraPagina, 200)

        //exemplo q deve funcionar val listaDeLivro = ArrayList<Model>()
        // arrayList.add(Model(..................... variaveis), R.drawable....)
        //val listaDeLivroAdd = emptyArray<Model>()


        val listaDelivro = arrayListOf(livro1, livro2, livro1, livro2, livro1, livro2, livro1, livro2, livro1, livro2, livro1, livro2, livro1, livro2, livro1, livro2, livro1, livro2)
        val recyclerViewLivro = findViewById<RecyclerView>(R.id.recycler_view_livro)
        recyclerViewLivro.layoutManager = LinearLayoutManager(this)
        recyclerViewLivro.adapter = LivroAdapter(listaDelivro)

        //Final Lista

        //Início SearchView

        //val searchView = findViewById<SearchView>(R.id.searchView)


        //Final SearchView

        //Floating Action Button Início

        val rotateOpen: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_open) }
        val rotateClose: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_close) }
        val fromBottom: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_from_bottom) }
        val toBottom: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_to_bottom) }

        val fabMain = findViewById<FloatingActionButton>(R.id.action_button_add)
        val fabBook = findViewById<ExtendedFloatingActionButton1>(R.id.action_button_livro)
        val fabNote = findViewById<ExtendedFloatingActionButton1>(R.id.action_button_anotacao)

        var clicked = false

        fabBook.setOnClickListener{
            val intent = Intent(this, CriandoLivroActivity::class.java)
            startActivity(intent)
        }

        fabNote.setOnClickListener{
            Toast.makeText(this, "Função não implementada", Toast.LENGTH_SHORT).show()
        }

        fun setVisibility(clicked: Boolean){
            if (!clicked){
                fabBook.visibility = View.VISIBLE
                fabNote.visibility = View.VISIBLE
            }
            else{
                fabBook.visibility = View.INVISIBLE
                fabNote.visibility = View.INVISIBLE
            }
        }

        fun setAnimation(clicked: Boolean){
            if(!clicked){
                fabBook.startAnimation(fromBottom)
                fabNote.startAnimation(fromBottom)
                fabMain.startAnimation(rotateOpen)
            }
            else{
                fabBook.startAnimation(toBottom)
                fabNote.startAnimation(toBottom)
                fabMain.startAnimation(rotateClose)
            }
        }

        fun onAddButtonClicked(){
            setVisibility(clicked)
            setAnimation(clicked)
            clicked = !clicked
        }

        fabMain.setOnClickListener{
            onAddButtonClicked()
        }
        //Floating Action Button Fim

    }
}
