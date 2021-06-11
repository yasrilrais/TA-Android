package com.example.tugasakhirapps.model

import com.google.gson.annotations.SerializedName

data class Staff(
        @field:SerializedName("user_nama")
        val userNama: String? = null,

        @field:SerializedName("user_id")
        val userId: String? = null,

        @field:SerializedName("user_nim")
        val userNim: String? = null,

        @field:SerializedName("user_email")
        val userEmail: String? = null,

        @field:SerializedName("user_password")
        val userPassword: String? = null
)
