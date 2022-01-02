package com.dm.tutorialdaynight2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatDelegate     //Importazione della Classe AppCompactDelegate

class MainActivity : AppCompatActivity() {

    private var rbDay: RadioButton? = null
    private var rbNight: RadioButton? = null
    private var rbDefault: RadioButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbDay = findViewById(R.id.rB_day)
        rbNight = findViewById(R.id.rB_night)
        rbDefault = findViewById(R.id.rB_default)

        //questo serve per selezionare il radioButton in base all'impostazione dell'aspetto
        //all'avvio dell'app
        when (AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_NO -> {
                rbDay!!.isChecked = true
            }
            AppCompatDelegate.MODE_NIGHT_YES -> {
                rbNight!!.isChecked = true
            }
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -> {
                rbDefault!!.isChecked = true
            }
        }

        rbDay!!.setOnClickListener {
            //Imposta il tema chiaro
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        rbNight!!.setOnClickListener {
            //Imposta il tema scuro
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }

        rbDefault!!.setOnClickListener {
            //Imposta il tema in base all'impostazione di sistema
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }


    }
}