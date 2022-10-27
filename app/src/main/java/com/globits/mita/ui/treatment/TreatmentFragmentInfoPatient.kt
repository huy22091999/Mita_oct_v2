package com.globits.mita.ui.treatment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentMitaBinding
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.patients.SetLayoutPatientInfo

class TreatmentFragmentInfoPatient : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfo(
            false,
            onBackStack = { (activity as TreatmentActivity).addFragmentPatient() },
            onPatientClick = { (activity as TreatmentActivity).addFragmentPatient() })
    }

}