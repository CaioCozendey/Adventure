package com.parzidev.adventure.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.parzidev.adventure.CriandoLivroActivity
import com.parzidev.adventure.model.LivroDataClass
import com.parzidev.adventure.R
import com.parzidev.adventure.adapter.LivroAdapter
import com.parzidev.adventure.model.LivroDataObject
import kotlinx.android.synthetic.main.fragment_biblioteca.*


class BibliotecaFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<LivroAdapter.LivroViewHolder>? = null

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
        animation()

        recyclerViewLivro.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = LivroAdapter(LivroDataObject.getAllData() as ArrayList<LivroDataClass>)
        }

    }

    //Função Floating Action Button animação
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

