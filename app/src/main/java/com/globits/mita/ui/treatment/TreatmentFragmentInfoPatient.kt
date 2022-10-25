package com.globits.mita.ui.treatment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentMitaBinding
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.patients.SetLayoutPatientInfo

class TreatmentFragmentInfoPatient : MitaBaseFragment<FragmentMitaBinding>() {
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMitaBinding {
        return FragmentMitaBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutPatientInfo(
                false,
                onBackStack = { (activity as TreatmentActivity).addFragmentPatient() },
                onPatientClick = { (activity as TreatmentActivity).addFragmentPatient() })
        }
    }

}