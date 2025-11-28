package com.example.protej.mvvmfirebase_crud.View

import android.R.attr.name
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.protej.mvvmfirebase_crud.Modal.Employee_Modal
import com.example.protej.mvvmfirebase_crud.R
import com.example.protej.mvvmfirebase_crud.Repository.Employee_Repositoey
import com.example.protej.mvvmfirebase_crud.ViewModal.Employee_ViewModal
import com.example.protej.mvvmfirebase_crud.ViewModal_Factory.Employee_Factory
import com.example.protej.mvvmfirebase_crud.databinding.ActivityMainBinding
import kotlinx.coroutines.channels.Channel

class MainActivity : AppCompatActivity() {
    lateinit var Binding: ActivityMainBinding
    lateinit var ViewModal: Employee_ViewModal

    val Repositoey = Employee_Repositoey()
    val factory = Employee_Factory(Repositoey)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(Binding.root)

        ViewModal = ViewModelProvider(this, factory).get(Employee_ViewModal::class.java)

        Binding.clicknext.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        ViewModal.Livedeta.observe(this) { Sucess ->
            if (Sucess) {
                Toast.makeText(this, "Sucessfull", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, " Not_Save ", Toast.LENGTH_LONG).show()
            }


        }

        Binding.etPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val phone = s.toString()
                if (phone.length < 10) {
                    Binding.phoneLayout.error = "Phone number must be 10 digits"
                } else {
                    Binding.phoneLayout.error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })


        Binding.btnSave.setOnClickListener {

            val Name = Binding.etName.text.toString().trim()
            val Id = Binding.etEmployeeId.text.toString().trim()
            val Department = Binding.etDepartment.text.toString().trim()
            val mobileNumber = Binding.etPhone.text.toString().trim()


            if (Name.isEmpty() || Id.isEmpty() || Department.isEmpty() || mobileNumber.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val id = Id.toIntOrNull() ?: 0
            val MobileNumber = mobileNumber.toLongOrNull() ?: 0L

            if (Binding.etPhone.text.toString().length < 10) {
                Binding.phoneLayout.error = "Please enter a valid 10-digit phone number"
            } else {
                Binding.phoneLayout.error = null

                ViewModal.Employee_Data(Name, id, Department, MobileNumber)

                clearInputs(
                    Binding.etName,
                    Binding.etEmployeeId,
                    Binding.etDepartment,
                    Binding.etPhone
                )


            }
        }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

        }

    fun clearInputs(Name: EditText, id: EditText, Department: EditText, MobileNumber: EditText){
        Name.text?.clear()
        id.text?.clear()
        Department.text?.clear()
        MobileNumber.text?.clear()

    }

    }
