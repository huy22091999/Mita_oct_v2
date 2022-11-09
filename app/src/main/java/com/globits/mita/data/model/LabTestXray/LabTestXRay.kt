package com.globits.mita.data.model.LabTestXray

import com.globits.mita.data.model.LabTest.LabTestItem
import com.google.gson.annotations.SerializedName
import java.util.*

data class LabTestXRay(

    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("heathOrganization")
    val heathOrganization: String? = null,

    @SerializedName("dateSpecified")
    val dateSpecified: Date? = null,

    @SerializedName("doctorSpecified")
    val doctorSpecified: String? = null,

    @SerializedName("labTestXRayItem")
    val labTestXRayItem: List<LabTestXRayItem>? = null,

) {
}