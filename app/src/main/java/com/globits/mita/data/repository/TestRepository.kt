package com.globits.mita.data.repository

import android.app.Presentation
import com.globits.mita.data.model.LabTest.LabTest
import com.globits.mita.data.model.LabTestXray.LabTestXRay
import com.globits.mita.data.model.Page
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.data.model.Prescriptions.PresCripTion
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

    fun getPrescription(patientId: Int): Observable<List<PresCripTion>> =
        api.getPrescription(patientId).subscribeOn(Schedulers.io())

    fun getLabTestXRay(patientId: Int): Observable<List<LabTestXRay>> =
        api.getLabTestXRay(patientId).subscribeOn(Schedulers.io())

    fun getLabTest(patientId: Int): Observable<List<LabTest>> =
        api.getLabTest(patientId).subscribeOn(Schedulers.io())
}