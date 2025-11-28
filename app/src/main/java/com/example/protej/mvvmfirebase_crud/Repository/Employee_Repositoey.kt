package com.example.protej.mvvmfirebase_crud.Repository

import android.util.Log
import com.example.protej.mvvmfirebase_crud.Modal.Employee_Modal
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.jvm.java

class Employee_Repositoey() {

    val FirebaseData: DatabaseReference = FirebaseDatabase.getInstance().getReference("Employees")


         fun Employee(MyEmpolyee: Employee_Modal, callback:(Boolean)-> Unit){


        val setchild = MyEmpolyee.name ?: "NoName"

        FirebaseData.child(setchild).setValue(MyEmpolyee)

            .addOnSuccessListener { callback(true)}.
            addOnFailureListener {  callback(false) }
    }


    fun getEmployees(onResult: (List<Employee_Modal>) -> Unit) {
        FirebaseData.get().addOnSuccessListener { snapshot ->
            val list = mutableListOf<Employee_Modal>()
            for (data in snapshot.children) {
                val employee = data.getValue(Employee_Modal::class.java)
                if (employee != null) list.add(employee)
            }
            onResult(list)
        }
    }




    }