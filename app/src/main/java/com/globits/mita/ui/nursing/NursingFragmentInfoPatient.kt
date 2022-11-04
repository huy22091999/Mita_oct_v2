package com.globits.mita.ui.nursing

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.ui.assign.AssignViewModel
import com.globits.mita.ui.treatment.view.SetLayoutPatientInfo

class NursingFragmentInfoPatient : MitaBaseFragment() {

    val viewModel: NursingViewModel by activityViewModel()

    var patient = mutableStateOf<Patient>(Patient())

    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfo("Thông tin bệnh nhân", true, onBackStack = {
            (activity as NursingActivity).removeBackStack()
        }, onPatientClick = { (activity as NursingActivity).addFragmentPatient() },
            patient = patient.value
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun invalidate(): Unit = withState(viewModel) {
        it.patient.also {
            if (it != null) {
                patient.value = it
            }
        }

    }

}