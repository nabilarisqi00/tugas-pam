package com.example.pam_ub

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Context

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val buttonHitung = findViewById<Button>(R.id.buttonHitung)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        buttonHitung.setOnClickListener {
            val num1 = editText1.text.toString().toDoubleOrNull()
            val num2 = editText2.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedOperation = when (radioGroup.checkedRadioButtonId) {
                R.id.radioButtonTambah -> "+"
                R.id.radioButtonKurang -> "-"
                R.id.radioButtonKali -> "*"
                R.id.radioButtonBagi -> "/"
                else -> ""
            }

            val result = when (selectedOperation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else {
                    Toast.makeText(this, "Tidak bisa dibagi nol", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else -> 0.0
            }


            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result) // Kirim hasil kalkulasi ke slide baru
            startActivity(intent)
        }


        button0.setOnClickListener { addText("0") }
        button1.setOnClickListener { addText("1") }
        button2.setOnClickListener { addText("2") }
        button3.setOnClickListener { addText("3") }
        button4.setOnClickListener { addText("4") }
        button5.setOnClickListener { addText("5") }
        button6.setOnClickListener { addText("6") }
        button7.setOnClickListener { addText("7") }
        button8.setOnClickListener { addText("8") }
        button9.setOnClickListener { addText("9") }
    }


    private fun addText(text: String) {

        val currentFocus = currentFocus
        if (currentFocus is EditText) {
            currentFocus.append(text)
        }
    }
}
