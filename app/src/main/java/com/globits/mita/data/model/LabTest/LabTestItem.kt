package com.globits.mita.data.model.LabTest

import com.google.gson.annotations.SerializedName
import java.util.*

data class LabTestItem(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("dateResult")
    val dateResult: Date? = null,

    @SerializedName("doctorResult")
    val doctorResult: String? = null,

    @SerializedName("labTestItemDetails")
    val labTestItemDetails: List<LabTestItemDetait>? = null,
) {
}