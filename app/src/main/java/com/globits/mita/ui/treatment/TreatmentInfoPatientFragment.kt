package com.globits.mita.ui.treatment

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.ui.treatment.view.SetLayoutPatientInfo


class TreatmentInfoPatientFragment : MitaBaseFragment() {

    val viewModel: TreatmentViewModel by activityViewModel()

    var patient = mutableStateOf<Patient>(Patient())

    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfo("Thông tin bệnh nhân",
            false,
            onBackStack = { (activity as TreatmentActivity).removeBackStack() },
            onPatientClick = {
               var patientId = it.id!!.toInt()
                (activity as TreatmentActivity).addFragmentPatient(patientId)
                             },
        patient = patient.value)
    }


    override fun invalidate(): Unit = withState(viewModel) {
        it.patient.also {
            if (it != null) {
                patient.value = it
            }
        }

    }

}