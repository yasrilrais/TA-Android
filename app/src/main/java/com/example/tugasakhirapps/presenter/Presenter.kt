package com.example.tugasakhirapps.presenter

import android.util.Log
import com.example.tugasakhirapps.model.ResultStaff
import com.example.tugasakhirapps.model.ResultStatus
import com.example.tugasakhirapps.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter (val crudView: CrudView) {

    //Fungsi GetData
    fun getData(){
        NetworkConfig.getService().getData()
                .enqueue(object : retrofit2.Callback<ResultStaff>{
                    override fun onFailure(call: Call<ResultStaff>, t: Throwable) {
                        crudView.onFailedGet(t.localizedMessage)
                        Log.d("Error", "Error Data")
                    }

                    override fun onResponse(call: Call<ResultStaff>, response: Response<ResultStaff>) {
                        if(response.isSuccessful){
                            val status = response.body()?.status
                            if (status == 200){
                                val data = response.body()?.staff
                                crudView.onSuccessGet(data)
                            } else{
                                crudView.onFailedGet("Error $status")
                            }
                        }
                    }

                })
    }


    //Add data
    fun addData(name : String, keluhan : String, fakultas : String, penerima : String, tanggal : String, tipe : String, tindakan : String, status : String){
        NetworkConfig.getService()
                .addStaff(name, keluhan, fakultas, penerima, tanggal, tipe, tindakan, status)
                .enqueue(object : retrofit2.Callback<ResultStatus>{
                    override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                        crudView.errorAdd(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                        if (response.isSuccessful && response.body()?.status == 200) {
                            crudView.successAdd(response.body()?.pesan ?: "")
                        }else {
                            crudView.errorAdd(response.body()?.pesan ?: "")
                        }
                    }

                })
    }


    //Hapus Data
    fun hapusData(id: String?){
        NetworkConfig.getService()
                .deleteStaff(id)
                .enqueue(object : retrofit2.Callback<ResultStatus>{
                    override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                        crudView.onErrorDelete(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                        if (response.isSuccessful && response.body()?.status == 200){
                            crudView.onSuccessDelete(response.body()?.pesan ?: "")
                        } else {
                            crudView.onErrorDelete(response.body()?.pesan ?: "")
                        }
                    }

                })
    }

    //Update Data
    fun updateData(id: String, name: String, keluhan : String, fakultas : String, penerima : String, tanggal : String, tipe : String, tindakan : String, status : String){
        NetworkConfig.getService()
                .updateStaff(id, name, keluhan, fakultas, penerima, tanggal, tipe, tindakan, status)
                .enqueue(object : retrofit2.Callback<ResultStatus>{
                    override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                        crudView.onErrorUpdate(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                        if (response.isSuccessful && response.body()?.status == 200){
                            crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                        }else{
                            crudView.onErrorUpdate(response.body()?.pesan ?: "")
                        }

                    }

                })
    }

    //Register Data
        fun register( nama : String?, nim : String?, email : String?, password : String?){
            NetworkConfig.getService()
                .register(nama, nim, email, password)
                .enqueue(object : Callback<ResultStatus> {
                    override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                        crudView.onFailedRegister(t.localizedMessage)
                    }

                    override fun onResponse(
                        call: Call<ResultStatus>,
                        response: Response<ResultStatus>
                    ) {
                        if (response.body()?.status == 200){
                            crudView.onSuccessRegister(response.body()?.message)
                        } else{
                            crudView.onFailedRegister(response.body()?.message)
                        }
                    }

                })
        }

    //Login Data
    fun login(email : String, password : String){
        NetworkConfig.getService()
                .login(email, password)
                .enqueue(object : Callback<ResultStatus>{
                    override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                        crudView.onFailedLogin(t.localizedMessage)
                    }
                    override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>) {
                        if (response.isSuccessful && response.body()?.status == 200){
                            crudView.onSuccessLogin(response.body()?.message, response.body()?.user)
                        } else {
                            crudView.onFailedLogin(response.body()?.message)
                        }
                    }
                })
    }
}