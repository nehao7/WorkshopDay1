package com.o7services.workshopday1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputActivity : AppCompatActivity() {
    var input: EditText? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        input = findViewById(R.id.edtInput)
        button = findViewById(R.id.btnTakeInput)
        button?.setOnClickListener {
            if (input?.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Enter message first", Toast.LENGTH_SHORT).show()
            } else {
                AlertDialog.Builder(this).apply {
                    setTitle("Greetings of the day✨🎉")
                    setMessage("Your Message : ${input?.text.toString()}")
                    setPositiveButton("Yes") { _, _ ->
                        Toast.makeText(
                            this@InputActivity,
                            "Positive Button Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    setNegativeButton("No") { _, _ ->
                        Toast.makeText(
                            this@InputActivity,
                            "Negative Button Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    setNeutralButton("Cancel") { _, _ ->
                        Toast.makeText(
                            this@InputActivity,
                            "Neutral Button Clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    show()
                }
            }
        }

    }
}