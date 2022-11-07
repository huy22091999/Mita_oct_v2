package com.globits.mita.data.model.LabTestXray

import com.google.gson.annotations.SerializedName
import java.util.*

data class LabTestXRayItem(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("dateResult")
    val dateResult: Date? = null,

    @SerializedName("doctorResult")
    val doctorResult: String? = null,

    @SerializedName("labTestXRayItemDetails")
    val labTestXRayItemDetails: List<LabTestItemXRayItemDetail>? = null,


) {
}