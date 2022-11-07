package com.globits.mita.data.model.LabTestXray

import com.google.gson.annotations.SerializedName

data class LabTestItemXRayItemDetail (

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("conclusion")
    val conclusion: String? = null,


        ){
}