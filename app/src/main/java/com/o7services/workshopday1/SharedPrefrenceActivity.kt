package com.o7services.workshopday1

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.workshopday1.databinding.ActivityMainBinding
import com.o7services.workshopday1.databinding.ActivitySharedPrefrenceBinding

class SharedPrefrenceActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedPrefrenceBinding
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivitySharedPrefrenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedPreferences = getSharedPreferences("EmployeeDetails", MODE_PRIVATE);
        // Load saved data if it exists
        loadSavedData();
        binding.btnSave.setOnClickListener(View.OnClickListener { saveData() })


    }
    private fun saveData() {
        // Get values from EditTexts
        val name: String = binding.edtName.getText().toString()
        val contact: String = binding.edtContact.getText().toString()
        val email: String = binding.edtEmail.getText().toString()
        val salary: String = binding.edtSalary.getText().toString()

        // Save data to SharedPreferences
        val editor = sharedPreferences?.edit()
        editor?.putString("name", name)
        editor?.putString("contact", contact)
        editor?.putString("email", email)
        editor?.putString("salary", salary)
        editor?.apply()
        Toast.makeText(this, "Details Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadSavedData() {
        // Retrieve saved data from SharedPreferences
        val name = sharedPreferences?.getString("name", "")
        val contact = sharedPreferences?.getString("contact", "")
        val email = sharedPreferences?.getString("email", "")
        val salary= sharedPreferences?.getString("salary", "")

        // Set values to EditTexts
        binding.edtName.setText(name)
        binding.edtContact.setText(contact)
        binding.edtEmail.setText(email)
        binding.edtSalary.setText(salary)
    }
}