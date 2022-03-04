package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.itesm.numeros.databinding.ActivityMainBinding
import android.widget.Toast
import android.text.method.ScrollingMovementMethod
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textView: TextView = findViewById(R.id.resultados)
        textView.movementMethod = ScrollingMovementMethod()
        val numList = mutableListOf<Int>()
        initUI(numList)
    }

    private fun initUI(numList: MutableList<Int>) {
        binding.botonAgregar.setOnClickListener {
           agregarNum(numList)
        }

        binding.promedio.setOnClickListener {
            promedio(numList)
        }

        binding.mayor.setOnClickListener {
            mayor(numList)
        }

        binding.pares.setOnClickListener {
            pares(numList)
        }

        binding.mostrar.setOnClickListener {
            mostrar(numList)
        }

        binding.borrar.setOnClickListener {
            borrar(numList)
        }
    }

    private fun agregarNum(numList: MutableList<Int>) {
        val nums = binding.inputNumeros.text.toString()
        val numsValue = nums.toIntOrNull()

        if (numsValue == null) {
            Toast.makeText(this, "¡No has ingresado un número!, intenta de nuevo.", Toast.LENGTH_SHORT).show()
            return
        }
        numList.add(numsValue)
        binding.resultados.text = "${numList}"
        binding.inputNumeros.text.clear()
    }

    private fun promedio(numList: MutableList<Int>) {
        if (numList.isEmpty()) {
            Toast.makeText(this, "¡La lista esta vacía!, ingresa un valor", Toast.LENGTH_SHORT).show()
            return
        }
        val promedio = numList.sum() / numList.count()
        binding.resultados.text = "${promedio}"
    }

    private fun mayor(numList: MutableList<Int>) {
        if (numList.isEmpty()) {
            Toast.makeText(this, "¡La lista esta vacía!, ingresa un valor", Toast.LENGTH_SHORT).show()
            return
        }
        val mayor = numList.maxOrNull()
        binding.resultados.text = "${mayor}"
    }

    private fun pares(numList: MutableList<Int>) {
        if (numList.isEmpty()) {
            Toast.makeText(this, "¡La lista esta vacía!, ingresa un valor", Toast.LENGTH_SHORT).show()
            return
        }
        val pairsList = numList.filter { x -> x % 2 == 0 }
        binding.resultados.text = "${pairsList}"
    }

    private fun mostrar(numList: MutableList<Int>) {
        if (numList.isEmpty()) {
            binding.resultados.text = "¡Lista vacía!"
            return
        }
        binding.resultados.text = "${numList}"
    }
    private fun borrar(numList: MutableList<Int>) {
        numList.clear()
        binding.resultados.text = ""
    }
}