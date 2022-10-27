package com.globits.mita.ui.nursing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentMitaBinding
import com.globits.mita.ui.assign.AssignActivity
import com.globits.mita.ui.patients.SetLayoutPatientInfo

class NursingFragmentInfoPatient : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfo(true, onBackStack = {
            (activity as NursingActivity).removeBackStack()
        }, onPatientClick = {(activity as NursingActivity).addFragmentPatient()})

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}