package com.parzidev.adventure

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CriandoLivroActivity : AppCompatActivity() {

    var pickedPhoto : Uri? = null
    var pickedBitmap : Bitmap? = null

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
            pickImage()
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

    fun pickImage() {
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        } else {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, 2)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            val galleryIntent= Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, 2)
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){
            pickedPhoto = data.data
            if (Build.VERSION.SDK_INT >= 28){
                val source = ImageDecoder.createSource(this.contentResolver, pickedPhoto!!)
                pickedBitmap = ImageDecoder.decodeBitmap(source)
                buttonImagemLivro.setImageBitmap(pickedBitmap)
            } else {
                pickedBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, pickedPhoto)
                buttonImagemLivro.setImageBitmap(pickedBitmap)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}
