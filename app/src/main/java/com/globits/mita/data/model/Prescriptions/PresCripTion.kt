package com.globits.mita.data.model.Prescriptions

import com.google.gson.annotations.SerializedName
import java.util.*

data class PresCripTion (

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("doctorSpecified")
    val doctorSpecified: String? = null,

    @SerializedName("dateSpecified")
    val dateSpecified: Date? = null,

    @SerializedName("heathOrganization")
    val heathOrganization: String? = null,

    @SerializedName("medicines")
    val medicines: List<Medicine>? = null,


        ){
}