package com.example.myapplicationaa

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rectanguloView: View =findViewById(R.id.rectangulo)
        val rectangulo:Rectangulo= Rectangulo(ContextCompat.getColor(this ,R.color.red),10,10)

        val buttonArriba: Button =findViewById(R.id.buttonArriba)
        val buttonAbajo: Button =findViewById(R.id.buttonAbajo)
        val buttonIzquierda: Button =findViewById(R.id.buttonIzquierda)
        val buttonDerecha: Button =findViewById(R.id.buttonDerecha)

        buttonArriba.setOnClickListener{
            rectangulo.moverArriba()

            actualizarVista(rectangulo,rectanguloView)
        }

        buttonAbajo.setOnClickListener{
            rectangulo.moverAbajo()

            actualizarVista(rectangulo,rectanguloView)
        }

        buttonIzquierda.setOnClickListener{
            rectangulo.moverIzquierda()

            actualizarVista(rectangulo,rectanguloView)
        }

        buttonDerecha.setOnClickListener{
            rectangulo.moverDerecha()

            actualizarVista(rectangulo,rectanguloView)
        }

    }
    private fun actualizarVista(rectangulo: Rectangulo, rectanguloView: View){

        rectanguloView.x=rectangulo.x.toFloat()
        rectanguloView.y=rectangulo.y.toFloat()

        rectanguloView.requestLayout()
    }
}