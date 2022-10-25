package com.globits.mita.ui.patients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentPatientInfoBinding


class PatientInfoFragment : MitaBaseFragment<FragmentPatientInfoBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPatientInfoBinding {
        return FragmentPatientInfoBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutPatientActivity(){}
        }
    }

}