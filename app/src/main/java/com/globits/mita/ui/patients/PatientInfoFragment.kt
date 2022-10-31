package com.globits.mita.ui.patients

import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.treatment.TreatmentActivity


class PatientInfoFragment : MitaBaseFragment() {

    @Composable
    override fun SetLayout() {
        SetLayoutPatientActivity(

        ) {
            if (activity is NursingActivity) {
                (activity as NursingActivity).removeBackStack()
            } else (activity as TreatmentActivity).removeBackStack()
        }
    }
    //`false`
}