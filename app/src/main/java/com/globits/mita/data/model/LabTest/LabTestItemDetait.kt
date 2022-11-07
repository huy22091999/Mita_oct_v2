package com.globits.mita.data.model.LabTest

import com.google.gson.annotations.SerializedName

data class LabTestItemDetait(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("labTestItemDetailTemplate")
    val labTestItemDetailTemplate: List<LabTestItemDetailTemplate>? = null,

    @SerializedName("result_number")
    val result_number: Float? = null,


) {
}