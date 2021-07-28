package com.ruzzante.calculadoraimc2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalculate.setBackgroundColor(Color.parseColor("#BC4676"));

        btnCalculate.setOnClickListener(){
            val weight:Double = (textWeight.text.toString()).toDoubleOrNull() ?: 0.0
            val height:Double = (textHeight.text.toString()).toDoubleOrNull() ?: 0.0
            val result = weight / (height * height)
            textView.setText(calculateIMC(weight = textWeight.text.toString(), height = textHeight.text.toString()))
        }
    }
    private fun calculateIMC(weight:String, height:String):String{
        if (weight.isNullOrBlank() || height.isNullOrBlank())
            return getString(R.string.HeightOrWeightIsNull)
        else{
            var result:String
            val imc = weight.toDouble() / (height.toDouble()*height.toDouble())
            when {
                imc <= 18.5 -> result = "Magreza."
                imc in 18.5..24.9 -> result = "Peso Normal."
                imc in 24.9..30.0 -> result = "Acima do Peso."
                imc in 30.0..40.0 -> result = "Obesidade."
                imc > 40.0-> result = "Obesidade Severa."
                else -> result = "Erro ao Calcular"
            }
            result += "\nSeu peso ideal é entre ${(18.5 * height.toDouble()).toInt().toString()} Kgs e ${(24.9 * height.toDouble()).toInt().toString()} Kgs"
            return result
        }

    }
}