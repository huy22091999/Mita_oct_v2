package com.globits.mita.ui.nursing

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.patients.SetLayoutPatientInfo

class NursingFragmentInfoPatient : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfo("Thông tin bệnh nhân", true, onBackStack = {
            (activity as NursingActivity).removeBackStack()
        }, onPatientClick = { (activity as NursingActivity).addFragmentPatient() })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}