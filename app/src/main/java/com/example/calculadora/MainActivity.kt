package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.toString

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val botao0 = findViewById<Button>(R.id.btn0)
        val botao1 = findViewById<Button>(R.id.btn1)
        val botao2 = findViewById<Button>(R.id.btn2)
        val botao3 = findViewById<Button>(R.id.btn3)
        val botao4 = findViewById<Button>(R.id.btn4)
        val botao5 = findViewById<Button>(R.id.btn5)
        val botao6 = findViewById<Button>(R.id.btn6)
        val botao7 = findViewById<Button>(R.id.btn7)
        val botao8 = findViewById<Button>(R.id.btn8)
        val botao9 = findViewById<Button>(R.id.btn9)

        val botaoMais = findViewById<Button>(R.id.btnMais)
        val botaoMenos = findViewById<Button>(R.id.btnMenos)
        val botaoVezes = findViewById<Button>(R.id.btnVezes)
        val botaoDividir = findViewById<Button>(R.id.btnDividir)
        val botaoIgual = findViewById<Button>(R.id.btnIgual)
        val botaoApagar = findViewById<Button>(R.id.btnApagar)
        val botaoVoltar = findViewById<Button>(R.id.btnVoltar)



        botao0.setOnClickListener(this::Botao0)
        botao1.setOnClickListener(this::Botao1)
        botao2.setOnClickListener(this::Botao2)
        botao3.setOnClickListener(this::Botao3)
        botao4.setOnClickListener(this::Botao4)
        botao5.setOnClickListener(this::Botao5)
        botao6.setOnClickListener(this::Botao6)
        botao7.setOnClickListener(this::Botao7)
        botao8.setOnClickListener(this::Botao8)
        botao9.setOnClickListener(this::Botao9)

        botaoMais.setOnClickListener(this::Somar)
        botaoMenos.setOnClickListener(this::Subtrair)
        botaoVezes.setOnClickListener(this::Multiplicar)
        botaoDividir.setOnClickListener(this::Dividir)
        botaoIgual.setOnClickListener(this::Igual)
        botaoApagar.setOnClickListener(this::Apagar)
        botaoVoltar.setOnClickListener(this::Voltar)
    }

    fun Somar(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val texto = txtDisplay.text

        if(texto == "Escolha um número")
            return
        else if(texto.contains("+")|| texto.contains("-")||
            texto.contains("x")|| texto.contains("/"))
            return
        txtDisplay.text = txtDisplay.text.toString() + "+"
    }

    fun Subtrair(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val texto = txtDisplay.text

        if(texto == "Escolha um número")
            return
        else if(texto.contains("+")|| texto.contains("-")||
            texto.contains("x")|| texto.contains("/"))
            return
        txtDisplay.text = txtDisplay.text.toString() + "-"
    }

    fun Multiplicar(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val texto = txtDisplay.text

        if(texto == "Escolha um número")
            return
        else if(texto.contains("+")|| texto.contains("-")||
            texto.contains("x")|| texto.contains("/"))
            return
        txtDisplay.text = txtDisplay.text.toString() + "x"
    }

    fun Dividir(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val texto = txtDisplay.text

        if(texto == "Escolha um número")
                return
            else if(texto.contains("+")|| texto.contains("-")||
                    texto.contains("x")|| texto.contains("/"))
                return
            txtDisplay.text = txtDisplay.text.toString() + "/"
    }

    fun Igual(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

        if(txtDisplay.text == "Escolha um número")
            return
        if(txtDisplay.text.contains("=")){
            txtDisplay.text = "Escolha um número"
            return
        }
        if(txtDisplay.text.contains("+")){
            val numeros = txtDisplay.text.split("+")
            val n1 = numeros[0].toInt()
            val n2 = numeros[1].toInt()
            if(n1 == 0 && n2 == 0){
                Toast.makeText(this, "Digite um número diferente de zero", Toast.LENGTH_LONG).show()
            }
            val resultado = n1 + n2
            txtDisplay.text = txtDisplay.text.toString() + " = ${resultado}"
        }

        else if(txtDisplay.text.contains("-")){
            val numeros = txtDisplay.text.split("-")
            val n1 = numeros[0].toInt()
            val n2 = numeros[1].toInt()
            if(n1 == 0 && n1 == 0){
                Toast.makeText(this, "Digite um número diferente de zero", Toast.LENGTH_LONG).show()
            }
            val resultado = n1 - n2
            txtDisplay.text = txtDisplay.text.toString() + " = ${resultado}"
        }

        else if(txtDisplay.text.contains("x")){
            val numeros = txtDisplay.text.split("x")
            val n1 = numeros[0].toInt()
            val n2 = numeros[1].toInt()
            if(n1 == 0 && n2 == 0){
                Toast.makeText(this, "Digite um número diferente de zero", Toast.LENGTH_LONG).show()
            }
            val resultado = n1 * n2
            txtDisplay.text = txtDisplay.text.toString() + " = ${resultado}"
        }

        else if(txtDisplay.text.contains("/")){
            val numeros = txtDisplay.text.split("/")
            val n1 = numeros[0].toDouble()
            val n2 = numeros[1].toDouble()
            val resultado = n1 / n2
            txtDisplay.text = txtDisplay.text.toString() + " = ${resultado}"
        }
    }

    fun Apagar(view: View) {
        var textoDisplay = findViewById<TextView>(R.id.txtDisplay)
        textoDisplay.text = "Escolha um número"
    }

    fun Voltar(view: View) {
        val textoDisplay = findViewById<TextView>(R.id.txtDisplay)
        if (textoDisplay.text == "Escolha um número")
            return
        if (textoDisplay.text.length == 1) {
            textoDisplay.text = "Escolha um número"
            return
        }
        textoDisplay.text = textoDisplay.text.dropLast( 1)
    }

    fun Botao0(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn0)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao1(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn1)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao2(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn2)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao3(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn3)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao4(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn4)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao5(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn5)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao6(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn6)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao7(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn7)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao8(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn8)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
    fun Botao9(view: View){
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)
        val botao = findViewById<Button>(R.id.btn9)

        if (txtDisplay.text.contains("=")){
            txtDisplay.text = botao.text }
        else if (txtDisplay.text == "Escolha um número"){
            txtDisplay.text = botao.text
        } else{
            txtDisplay.text = txtDisplay.text.toString() + botao.text.toString()
        }
    }
}