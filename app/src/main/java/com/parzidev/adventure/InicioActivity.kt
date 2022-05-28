package com.parzidev.adventure

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import androidx.fragment.app.Fragment
import com.parzidev.adventure.fragment.*
import kotlinx.android.synthetic.main.activity_inicio.*

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val bibliotecaFragment = BibliotecaFragment()
        val favoritoFragment = FavoritoFragment()
        val concluidoFragment = ConcluidoFragment()
        val anotacoesFragment = AnotacoesFragment()
        val lojaFragment = LojaFragment()

        setCurrentFragment(bibliotecaFragment)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.bottomNavigationBiblioteca -> {
                    setCurrentFragment(bibliotecaFragment)
                }
                R.id.bottomNavigationFavorito -> {
                    setCurrentFragment(favoritoFragment)
                }
                R.id.bottomNavigationConcluido -> {
                    setCurrentFragment(concluidoFragment)
                }
                R.id.bottomNavigationAnotacoes -> {
                    setCurrentFragment(anotacoesFragment)
                }
                R.id.bottomNavigationLoja -> {
                    setCurrentFragment(lojaFragment)
                }
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}
