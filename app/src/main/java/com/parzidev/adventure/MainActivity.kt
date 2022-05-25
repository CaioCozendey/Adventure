package com.parzidev.adventure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val buttonCriarConta = findViewById<Button>(R.id.criar_conta)
        val buttonEsqueceuSenha = findViewById<Button>(R.id.esqueceu_a_senha_btn)
        val buttonLogin = findViewById<Button>(R.id.login_btn)

        buttonLogin.setOnClickListener {
            Toast.makeText(this, "Função não implementada", Toast.LENGTH_SHORT).show()
        }

        buttonEsqueceuSenha.setOnClickListener {
            val intent = Intent(this, LivroInformacoesActivity::class.java)
            startActivity(intent)
        }

        buttonCriarConta.setOnClickListener {
            val intent = Intent(this,CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}