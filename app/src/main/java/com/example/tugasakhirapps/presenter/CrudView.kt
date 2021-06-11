package com.example.tugasakhirapps.presenter

import com.example.tugasakhirapps.model.DataItem
import com.example.tugasakhirapps.model.Staff

interface CrudView {
    //Untuk get data
    fun onSuccessGet(data: List<DataItem>?)
    fun onFailedGet(msg : String)

    //Untuk Delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)

    //Untuk Add
    fun successAdd(msg : String)
    fun errorAdd(msg: String)

    //Untuk Update
    fun onSuccessUpdate(msg : String)
    fun onErrorUpdate(msg : String)

    //Untuk Register
    fun onSuccessRegister(msg : String?)
    fun onFailedRegister(msg: String?)

    //Untuk Login
    fun onSuccessLogin (msg : String?, data : Staff?)
    fun onFailedLogin (msg : String?)

}