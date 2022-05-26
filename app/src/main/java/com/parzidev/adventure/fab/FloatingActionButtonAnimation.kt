package com.parzidev.adventure.fab

import android.content.Intent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.parzidev.adventure.CriandoLivroActivity
import com.parzidev.adventure.R

class FloatingActionButtonAnimation {
    fun animation(){
        //Floating Action Button Início
        val rotateOpen: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_open) }
        val rotateClose: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_close) }
        val fromBottom: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_from_bottom) }
        val toBottom: Animation by lazy{ AnimationUtils.loadAnimation(this, R.anim.fab_to_bottom) }

        val fabMain = findViewById<FloatingActionButton>(R.id.action_button_add)
        val fabBook = findViewById<ExtendedFloatingActionButton>(R.id.action_button_livro)
        val fabNote = findViewById<ExtendedFloatingActionButton>(R.id.action_button_anotacao)

        var clicked = false

        fabBook.setOnClickListener{
            val intent = Intent(, CriandoLivroActivity::class.java)
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