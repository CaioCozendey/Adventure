package com.parzidev.adventure

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.parzidev.adventure.model.LivroDataObject
import kotlinx.android.synthetic.main.activity_criando_livro.*

class CriandoLivroActivity : AppCompatActivity() {

    companion object {
        const val IMAGE_REQUEST_CODE = 100
    }

    private lateinit var buttonImagemLivro: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criando_livro)
        supportActionBar?.hide()
        val buttonImagemLivro = findViewById<ImageButton>(R.id.inputImageLivro)

        buttonImagemLivro.setOnClickListener {
            pickImageFromGallery()
        }


        button_criar.setOnClickListener {
            if(buttonImagemLivro.drawable != null
            && editTextNomeLivro.text.toString().trim{it <= ' '}.isNotEmpty()
            && editTextNomeAutor.text.toString().trim{it <= ' '}.isNotEmpty()
            && editTextTotalPaginas.text.toString().trim{it <= ' '}.isNotEmpty()) {

                val setImageLivro = buttonImagemLivro.drawable
                val setNomeLivro = editTextNomeLivro.text.toString()
                val setNomeAutor = editTextNomeAutor.text.toString()
                val setTotalPaginas = editTextTotalPaginas.text.toString().toInt()
                val setPaginaAtual = editTextPaginaAtual.text.toString().toInt()

                LivroDataObject.setData(setNomeLivro, setNomeAutor, setImageLivro, setTotalPaginas, setPaginaAtual)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            inputImageLivro.setImageURI(data?.data)
        }
    }

    override fun onBackPressed() {
        finish()
    }
}
