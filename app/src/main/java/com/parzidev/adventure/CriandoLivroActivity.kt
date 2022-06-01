package com.parzidev.adventure

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
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
        val criarButton = findViewById<Button>(R.id.button_criar)
        val buttonImagemLivro = findViewById<ImageButton>(R.id.inputImageLivro)

        buttonImagemLivro.setOnClickListener {
            pickImageFromGallery()
        }


        criarButton.setOnClickListener {
            criaLivroNaLista()
        }
    }

    private fun criaLivroNaLista() {
        val intent = Intent(this, MainActivity::class.java)
            //var buttonInputImagemLivro = findViewById<ImageButton>(R.id.inputImageLivro)

            //Nome Livro
            val inputNomeLivro = findViewById<EditText>(R.id.editTextNomeLivro).text.toString()
            intent.putExtra("EXTRA_MESSAGE_NOME_LIVRO", inputNomeLivro)

            //Nome Autor
            val inputNomeAutor = findViewById<EditText>(R.id.editTextNomeAutor).text.toString()
            intent.putExtra("EXTRA_MESSAGE_NOME_AUTOR", inputNomeAutor)

            //Número Total de Páginas
            val inputNumeroPaginas = findViewById<EditText>(R.id.editTextTotalPaginas).text.toString().toInt()
            intent.putExtra(EXTRA_MESSAGE, inputNumeroPaginas)

       startActivity(intent)
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
