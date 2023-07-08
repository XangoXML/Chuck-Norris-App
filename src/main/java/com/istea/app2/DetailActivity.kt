package com.istea.app2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("name")

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewBirthplace: TextView = findViewById(R.id.textViewBirthplace)
        val textViewAge: TextView = findViewById(R.id.textViewAge)
        val textViewAlias: TextView = findViewById(R.id.textViewAlias)
        val textViewSuperpowers: TextView = findViewById(R.id.textViewSuperpowers)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        if (name == "Steve Rogers") {
            textViewName.text = "Nombre: Steve Rogers"
            textViewBirthplace.text = "Nacimiento: Estados Unidos"
            textViewAge.text = "Edad: 35 años"
            textViewAlias.text = "Alias: Capitán América"
            textViewSuperpowers.text = "Superpoderes: Fuerza sobrehumana, lanzamiento de escudo, resistencia"
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}
