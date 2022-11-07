package com.globits.mita.ui.patients

import androidx.compose.runtime.Composable
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.treatment.TreatmentActivity
import com.globits.mita.ui.treatment.TreatmentViewModel


class PatientInfoFragment : MitaBaseFragment() {

    val viewModel: PatientViewModel by fragmentViewModel()

    @Composable
    override fun SetLayout() {
        SetLayoutPatientActivity(
        ) {
            if (activity is NursingActivity) {
                (activity as NursingActivity).removeBackStack()
            } else (activity as TreatmentActivity).removeBackStack()
        }
    }

    override fun invalidate() = withState(viewModel) {

    }

}