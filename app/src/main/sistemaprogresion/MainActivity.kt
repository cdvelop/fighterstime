package com.example.pruebasdecodigo

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private var currentLevel = 1
    private var currentExp = 0
    private var totalExpAccumulated = 0
    private var expToNextLevel = 250 // Nivel 1 a 2 requiere 250 EXP

    // Atributos del personaje
    private var vida = 100
    private var ataque = 20
    private var defensa = 15
    private var velocidad = 10

    // Referencias a las vistas
    private lateinit var tvLevel: TextView
    private lateinit var tvExp: TextView
    private lateinit var tvTotalExp: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnDefeatEnemy: MaterialButton
    private lateinit var btnReset: MaterialButton

    // Atributos UI
    private lateinit var tvVida: TextView
    private lateinit var tvAtaque: TextView
    private lateinit var tvDefensa: TextView
    private lateinit var tvVelocidad: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setupListeners()
        updateUI()
    }

    private fun initViews() {
        tvLevel = findViewById(R.id.tvLevel)
        tvExp = findViewById(R.id.tvExp)
        tvTotalExp = findViewById(R.id.tvTotalExp)
        progressBar = findViewById(R.id.progressBar)
        btnDefeatEnemy = findViewById(R.id.btnDefeatEnemy)
        btnReset = findViewById(R.id.btnReset)
        tvVida = findViewById(R.id.tvVida)
        tvAtaque = findViewById(R.id.tvAtaque)
        tvDefensa = findViewById(R.id.tvDefensa)
        tvVelocidad = findViewById(R.id.tvVelocidad)
        progressBar.max = expToNextLevel
    }

    private fun setupListeners() {
        btnDefeatEnemy.setOnClickListener { defeatEnemy() }
        btnReset.setOnClickListener { resetProgress() }
    }

    private fun defeatEnemy() {
        val expGained = (15..35).random()
        gainExperience(expGained)
    }

    private fun gainExperience(expGained: Int) {
        currentExp += expGained
        totalExpAccumulated += expGained
        while (currentExp >= expToNextLevel) {
            levelUp()
        }
        updateUI()
    }

    private fun levelUp() {
        currentExp -= expToNextLevel
        currentLevel++
        vida += 10
        ataque += 5
        defensa += 3
        velocidad += 1
        expToNextLevel = calculateExpForNextLevel(currentLevel)
        progressBar.max = expToNextLevel
        showLevelUpMessage()
    }

    private fun calculateExpForNextLevel(currentLevel: Int): Int {
        return (currentLevel * 150) + 100
    }

    private fun showLevelUpMessage() {
        val originalText = tvLevel.text
        tvLevel.text = "¡NIVEL $currentLevel! (+10 Vida, +5 Ataque, +3 Defensa, +1 Velocidad)"
        tvLevel.postDelayed({ updateUI() }, 3000)
    }

    private fun resetProgress() {
        currentLevel = 1
        currentExp = 0
        totalExpAccumulated = 0
        expToNextLevel = 250
        vida = 100
        ataque = 20
        defensa = 15
        velocidad = 10
        progressBar.max = expToNextLevel
        updateUI()
    }

    private fun updateUI() {
        tvLevel.text = "Nivel: $currentLevel"
        tvExp.text = "$currentExp / $expToNextLevel EXP"
        tvTotalExp.text = "Total Acumulada: $totalExpAccumulated"
        progressBar.progress = currentExp
        tvVida.text = "❤️ Vida: $vida"
        tvAtaque.text = "⚔️ Ataque: $ataque"
        tvDefensa.text = "🛡️ Defensa: $defensa"
        tvVelocidad.text = "⚡ Velocidad: $velocidad"
    }

    private fun getProgressionTable(): String {
        val sb = StringBuilder()
        sb.append("Tabla de Progresión:\n")
        var totalAccumulated = 0
        for (level in 1..5) {
            val expNeeded = calculateExpForNextLevel(level)
            totalAccumulated += expNeeded
            sb.append("Nivel $level -> ${level + 1}: $expNeeded EXP (Total: $totalAccumulated)\n")
        }
        return sb.toString()
    }
}