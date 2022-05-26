package com.parzidev.adventure

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CriandoLivroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criando_livro)
        supportActionBar?.hide()
        val criarButton = findViewById<Button>(R.id.button_criar)

        criarButton.setOnClickListener {
            criaLivroNaLista()
        }
    }

        private fun criaLivroNaLista() {
            val intent = Intent(this, InicioActivity::class.java)
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
}
