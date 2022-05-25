package com.parzidev.adventure

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.parzidev.adventure.adapter.LivroAdapter
import com.parzidev.adventure.fragment.BibliotecaFragment
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton as ExtendedFloatingActionButton1


class BibliotecaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)
        supportActionBar?.hide()

        //Início Lista
        val nomeLivro = intent.getStringExtra("EXTRA_MESSAGE_NOME_LIVRO")
        val nomeAutor = intent.getStringExtra("EXTRA_MESSAGE_NOME_AUTOR")
        val totalPaginas = intent.getIntExtra(EXTRA_MESSAGE, 0)

        val livro3 = Livro(
            nomeLivro.toString(),
            nomeAutor.toString(),
            "https://images-na.ssl-images-amazon.com/images/I/81sppP3MAkL.jpg",
            totalPaginas.toString(),
            1)

        val listaDelivro = arrayListOf(livro3)
        val recyclerViewLivro = findViewById<RecyclerView>(R.id.recycler_view_livro)
        recyclerViewLivro.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = LivroAdapter(listaDelivro)
        }
        //Final Lista

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