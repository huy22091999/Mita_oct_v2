package com.globits.mita.data.network

import com.globits.mita.data.model.Page
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.data.model.Responsive
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


interface TestApi {

    @POST("patients/search")
    fun getPatient(@Body patientFilter: PatientFilter ): Observable<Page<Patient>>
}

data class SearchDto(
    val code: String,
    val name: String
)
