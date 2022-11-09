package com.globits.mita.ui.patients

import android.app.Presentation
import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.globits.mita.data.model.LabTest.LabTest
import com.globits.mita.data.model.LabTestXray.LabTestXRay
import com.globits.mita.data.model.Page
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.Prescriptions.PresCripTion
import com.globits.mita.data.model.Responsive

data class PatientViewState(
    var asyncPresentation: Async<List<PresCripTion>> = Uninitialized,
    var asyncLabTestXRay: Async<List<LabTestXRay>> = Uninitialized,
    var asyncLabTest: Async<List<LabTest>> = Uninitialized,

) : MvRxState {
    fun isLoading() = asyncPresentation is Loading
}