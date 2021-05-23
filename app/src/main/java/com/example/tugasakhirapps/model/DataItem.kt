package com.example.tugasakhirapps.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataItem : Serializable{

    @field:SerializedName("staff_name")
    val staffName: String? = null

    @field:SerializedName("staff_id")
    val staffId: String? = null

    @field:SerializedName("staff_keluhan")
    val staffKeluhan: String? = null

    @field:SerializedName("staff_fakultas")
    val staffFakultas: String? = null

    @field:SerializedName("staff_penerima")
    val staffPenerima: String? = null

    @field:SerializedName("staff_tanggal")
    val staffTanggal: String? = null

    @field:SerializedName("staff_tipe")
    val staffTipe: String? = null

    @field:SerializedName("staff_tindakan")
    val staffTindakan: String? = null
}