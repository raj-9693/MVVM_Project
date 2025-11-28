package com.example.protej.mvvmfirebase_crud.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.protej.mvvmfirebase_crud.Adapter.Employee_Adapter
import com.example.protej.mvvmfirebase_crud.Modal.Employee_Modal
import com.example.protej.mvvmfirebase_crud.R
import com.example.protej.mvvmfirebase_crud.Repository.Employee_Repositoey
import com.example.protej.mvvmfirebase_crud.ViewModal.Employee_ViewModal
import com.example.protej.mvvmfirebase_crud.ViewModal_Factory.Employee_Factory
import com.example.protej.mvvmfirebase_crud.databinding.ActivityMain2Binding



class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var Adapter: Employee_Adapter
    lateinit var ViewModal: Employee_ViewModal

    lateinit var EmployeeDeta: ArrayList<Employee_Modal>
    val Repositoey = Employee_Repositoey()
    val Factory = Employee_Factory(Repositoey)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewModal = ViewModelProvider(this, Factory).get(Employee_ViewModal::class.java)

        EmployeeDeta = ArrayList()
        Adapter = Employee_Adapter(this, EmployeeDeta)

        binding.recyclerview1.layoutManager = LinearLayoutManager(this)
        binding.recyclerview1.adapter = Adapter

        ViewModal.fetchEmployees()


        ViewModal.MutableDetafech.observe(this) { list ->

            EmployeeDeta.clear()
            EmployeeDeta.addAll(list)
            Adapter.notifyDataSetChanged()

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}