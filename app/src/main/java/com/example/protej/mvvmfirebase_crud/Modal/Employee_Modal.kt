package com.example.protej.mvvmfirebase_crud.Modal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


  @Parcelize

data class Employee_Modal(
    val name: String? = null,
    val id: Int? = null,
    val department: String? = null,
    val phoneNumber: Long? = null
): Parcelable

