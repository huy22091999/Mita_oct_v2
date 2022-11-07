package com.globits.mita.data.model.LabTest

import com.google.gson.annotations.SerializedName

data class LabTestItemDetailTemplate(

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("referenceNumberMax")
    val referenceNumberMax: Float? = null,

    @SerializedName("referenceNumberMin")
    val referenceNumberMin: Float? = null,

    @SerializedName("name")
    val name: String? = null,

) {
}