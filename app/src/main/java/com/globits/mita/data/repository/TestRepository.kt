package com.globits.mita.data.repository

import com.globits.mita.data.model.Page
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.data.model.Responsive
import com.globits.mita.data.network.SearchDto
import com.globits.mita.data.network.TestApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(
    val api: TestApi
) {

    fun getPatient(patientFilter: PatientFilter): Observable<Page<Patient>> =
        api.getPatient(patientFilter).subscribeOn(Schedulers.io())
}