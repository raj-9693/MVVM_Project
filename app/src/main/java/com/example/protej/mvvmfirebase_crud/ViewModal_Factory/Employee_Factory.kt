package com.example.protej.mvvmfirebase_crud.ViewModal_Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.protej.mvvmfirebase_crud.Repository.Employee_Repositoey
import com.example.protej.mvvmfirebase_crud.ViewModal.Employee_ViewModal
import kotlin.jvm.java

class Employee_Factory(val Repositoet: Employee_Repositoey): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(Employee_ViewModal::class.java)) {
            return Employee_ViewModal(Repositoet) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

