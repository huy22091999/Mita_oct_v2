package com.globits.mita.data.model

import com.google.gson.annotations.SerializedName
import java.sql.Date
import java.util.*

data class Document(

    @SerializedName("id")
    val id: Long? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("dateXRay")
    val dateXRay: java.util.Date? = null,

    @SerializedName("patient")
    val patient: Patient? = null,

) {
}