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

        val button_criar_conta = findViewById<Button>(R.id.criar_conta)
        val button_esqueceu_senha = findViewById<Button>(R.id.esqueceu_a_senha_btn)
        val button_login = findViewById<Button>(R.id.login_btn)

        button_login.setOnClickListener {
            Toast.makeText(this, "Função não implementada", Toast.LENGTH_SHORT).show()
        }

        button_esqueceu_senha.setOnClickListener {
            Toast.makeText(this, "Função não implementada", Toast.LENGTH_SHORT).show()
        }

        button_criar_conta.setOnClickListener {
            val intent = Intent(this,CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}