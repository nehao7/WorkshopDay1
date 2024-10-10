package com.o7services.workshopday1

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.workshopday1.databinding.ActivityMainBinding
import com.o7services.workshopday1.databinding.ActivitySharedPrefrenceBinding

class SharedPrefrenceActivity : AppCompatActivity() {
    lateinit var btnSave: Button
    lateinit var etName: EditText
    lateinit var etContact: EditText
    lateinit var etEmail: EditText
    lateinit var edtSalary: EditText
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefrence)
        etName = findViewById(R.id.edtName)
        etContact = findViewById(R.id.edtContact)
        etEmail = findViewById(R.id.edtEmail)
        edtSalary = findViewById(R.id.edtSalary)
        btnSave = findViewById(R.id.btnSave)
        sharedPreferences = getSharedPreferences("EmployeeDetails", MODE_PRIVATE);
        // Load saved data if it exists
        loadSavedData();
       btnSave.setOnClickListener(View.OnClickListener { saveData() })


    }
    private fun saveData() {
        // Get values from EditTexts
        val name: String = etName.text.toString()
        val contact: String = etContact.text.toString()
        val email: String = etEmail.text.toString()
        val salary: String = edtSalary.text.toString()

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
        etName.setText(name)
        etContact.setText(contact)
        etEmail.setText(email)
        edtSalary.setText(salary)
    }
}