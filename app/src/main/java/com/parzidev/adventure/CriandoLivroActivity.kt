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
            val intent = Intent(this, BibliotecaActivity::class.java)
                //var buttonInputImagemLivro = findViewById<ImageButton>(R.id.inputImageLivro)

                //Nome Livro
                val inputNomeLivro = findViewById<EditText>(R.id.editTextNomeLivro)
                val enviaNomeLivro = inputNomeLivro.text.toString()
                intent.putExtra("EXTRA_NOME_LIVRO", enviaNomeLivro)

                //Nome Autor
                val inputNomeAutor = findViewById<EditText>(R.id.editTextNomeAutor)
                val enviaNomeAutor = inputNomeAutor.text.toString()
                intent.putExtra("EXTRA_NOME_AUTOR", enviaNomeAutor)

                //Número Total de Páginas
                val inputNumeroPaginas = findViewById<EditText>(R.id.layoutEditTextTotalPaginas)
                val enviaNumeroTotalPaginas = inputNumeroPaginas.text.toString().toInt()
                intent.putExtra("EXTRA_TOTAL_NUMERO_PAGINAS", enviaNumeroTotalPaginas)

            startActivity(intent)

        }
}
