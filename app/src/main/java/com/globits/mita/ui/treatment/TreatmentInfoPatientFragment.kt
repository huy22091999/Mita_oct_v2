package com.globits.mita.ui.treatment

import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.treatment.view.SetLayoutPatientInfo

class TreatmentInfoPatientFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfo("Thông tin bệnh nhân",
            false,
            onBackStack = { (activity as TreatmentActivity).removeBackStack() },
            onPatientClick = { (activity as TreatmentActivity).addFragmentPatient() })
    }

}