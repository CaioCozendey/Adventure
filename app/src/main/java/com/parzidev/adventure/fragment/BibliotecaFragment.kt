package com.parzidev.adventure.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.parzidev.adventure.CriandoLivroActivity
import com.parzidev.adventure.R


class BibliotecaFragment : Fragment() {

    private lateinit var fabMain: FloatingActionButton
    private lateinit var fabBook: ExtendedFloatingActionButton
    private lateinit var fabNote: ExtendedFloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Início Lista
        /*val nomeLivro = intent.getStringExtra("EXTRA_MESSAGE_NOME_LIVRO")
        val nomeAutor = intent.getStringExtra("EXTRA_MESSAGE_NOME_AUTOR")
        val totalPaginas = view.intent.getIntExtra(AlarmClock.EXTRA_MESSAGE, 0)

        val livro3 = Livro(
            nomeLivro.toString(),
            nomeAutor.toString(),
            "https://images-na.ssl-images-amazon.com/images/I/81sppP3MAkL.jpg",
            totalPaginas.toString(),
            1)

        val listaDelivro = arrayListOf(livro3)
        val recyclerViewLivro = view?.findViewById<RecyclerView>(R.id.recycler_view_livro)
        recyclerViewLivro.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = LivroAdapter(listaDelivro)
        }*/
        //Final Lista

        animation()
    }
    fun animation() {

        val fabMain = view?.findViewById<FloatingActionButton>(R.id.action_button_add)
        val fabBook = view?.findViewById<ExtendedFloatingActionButton>(R.id.action_button_livro)
        val fabNote = view?.findViewById<ExtendedFloatingActionButton>(R.id.action_button_anotacao)
        //Floating Action Button Início
        val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_open) }
        val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_close) }
        val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_from_bottom) }
        val toBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.fab_to_bottom) }

        var clicked = false

        fabBook?.setOnClickListener {
            val intent = Intent(context, CriandoLivroActivity::class.java)
            startActivity(intent)
        }

        fabNote?.setOnClickListener {
            Toast.makeText(context, "Função não implementada", Toast.LENGTH_SHORT).show()
        }

        fun setVisibility(clicked: Boolean) {
            if (!clicked) {
                fabBook?.visibility = View.VISIBLE
                fabNote?.visibility = View.VISIBLE
            } else {
                fabBook?.visibility = View.INVISIBLE
                fabNote?.visibility = View.INVISIBLE
            }
        }

        fun setAnimation(clicked: Boolean) {
            if (!clicked) {
                fabBook?.startAnimation(fromBottom)
                fabNote?.startAnimation(fromBottom)
                fabMain?.startAnimation(rotateOpen)
            } else {
                fabBook?.startAnimation(toBottom)
                fabNote?.startAnimation(toBottom)
                fabMain?.startAnimation(rotateClose)
            }
        }

        fun onAddButtonClicked() {
            setVisibility(clicked)
            setAnimation(clicked)
            clicked = !clicked
        }

        fabMain?.setOnClickListener {
            onAddButtonClicked()
        }
        //Floating Action Button Fim
    }
}

