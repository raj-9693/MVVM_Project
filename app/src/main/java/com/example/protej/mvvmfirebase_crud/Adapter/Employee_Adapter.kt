package com.example.protej.mvvmfirebase_crud.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.protej.mvvmfirebase_crud.Modal.Employee_Modal
import com.example.protej.mvvmfirebase_crud.R
import com.example.protej.mvvmfirebase_crud.View.MainActivity2


class Employee_Adapter(val context: Activity, val EmployeesoData: ArrayList<Employee_Modal>):

    RecyclerView.Adapter<Employee_Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val Employee_Name = view.findViewById<TextView>(R.id.tvName)
        val Empoloyee_Id =view.findViewById<TextView>(R.id.tvID)
        val Employee_Department=view.findViewById<TextView>(R.id.tvDepartment)
        val Employee_MobileNumber = view.findViewById<TextView>(R.id.tvPhone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    val setvalue= LayoutInflater.from(parent.context).inflate(R.layout.employee_detalis_card,parent,false)
        return ViewHolder(setvalue)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
val Employee_Data=EmployeesoData[position]

        holder.Employee_Name.text=Employee_Data.name
        holder.Empoloyee_Id.text=Employee_Data.id.toString()
        holder.Employee_Department.text=Employee_Data.department
        holder.Employee_MobileNumber.text=Employee_Data.phoneNumber.toString()




    }

    override fun getItemCount(): Int {
        return EmployeesoData.size

    }


}