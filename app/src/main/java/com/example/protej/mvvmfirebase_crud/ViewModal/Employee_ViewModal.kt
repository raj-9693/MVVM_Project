package com.example.protej.mvvmfirebase_crud.ViewModal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.protej.mvvmfirebase_crud.Modal.Employee_Modal
import com.example.protej.mvvmfirebase_crud.Repository.Employee_Repositoey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Employee_ViewModal(private val Repository: Employee_Repositoey): ViewModel() {

val TAG: String="Kotlin"
   private val _MutableDeta= MutableLiveData<Boolean>()
    val Livedeta: LiveData<Boolean> = _MutableDeta

    private val _MutableDetafech = MutableLiveData<List<Employee_Modal>>()
    val MutableDetafech: LiveData<List<Employee_Modal>> = _MutableDetafech


    fun Employee_Data(Name:String,Id:Int,Department:String,mobileNumber:Long){

              val ViewmodalDeta= Employee_Modal(Name,Id,Department,mobileNumber)



            Log.d(TAG, "Thread: ${Thread.currentThread().name}")

            Repository.Employee(ViewmodalDeta,) { Sucess ->
                _MutableDeta.value = Sucess
            }



    }

    fun fetchEmployees() {
        Repository.getEmployees { fetchedList ->
            _MutableDetafech.value = fetchedList
        }
    }

}