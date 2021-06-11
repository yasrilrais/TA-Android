package com.example.tugasakhirapps.network

import com.example.tugasakhirapps.model.ResultStaff
import com.example.tugasakhirapps.model.ResultStatus
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object NetworkConfig {

    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        return okHttpClient
    }

    //Retrofit

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://192.168.43.146/ci-news/index.php/ServerApi/")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getService() = getRetrofit().create(StaffService::class.java)
}
interface StaffService{

    //Fungsi Create Data
    @FormUrlEncoded
    @POST("addStaff")
    fun addStaff(@Field("name") name : String,
                 @Field("keluhan") keluhan : String,
                 @Field("fakultas") fakultas : String,
                 @Field("penerima") penerima : String,
                 @Field("tanggal") tanggal : String,
                 @Field("tipe") tipe : String,
                 @Field("tindakan") tindakan : String,
                 @Field("status") status : String) : Call<ResultStatus>



    //Fungsi Get Data
    @GET("getDataStaff")

    fun getData() : Call<ResultStaff>

    //Fungsi Delete Data
    @FormUrlEncoded
    @POST("deleteStaff")
    fun deleteStaff(@Field("id") id: String?) : Call<ResultStatus>

    //Fungsi Update Data
    @FormUrlEncoded
    @POST("updateStaff")
    fun updateStaff(@Field("id") id: String,
                    @Field("name") name : String,
                    @Field("keluhan") keluhan : String,
                    @Field("fakultas") fakultas : String,
                    @Field("penerima") penerima : String,
                    @Field("tanggal") tanggal : String,
                    @Field("tipe") tipe : String,
                    @Field("tindakan") tindakan : String,
                    @Field("status") status : String) : Call<ResultStatus>

    //Fungsi Register
    @FormUrlEncoded
    @POST("registerStaff")
    fun register(@Field("nama") nama : String?,
                 @Field("nim") nim : String?,
                 @Field("email") email : String?,
                 @Field("password") password : String?) : Call<ResultStatus>

    //Fungsi Login
    @FormUrlEncoded
    @POST("loginStaff")
    fun login(@Field("email") email : String?,
              @Field("password") password: String?) : Call<ResultStatus>
}