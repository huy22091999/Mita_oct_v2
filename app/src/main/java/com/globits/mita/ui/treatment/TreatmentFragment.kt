package com.globits.mita.ui.treatment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.R
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentTreatmentBinding
import com.globits.mita.ui.MainActivity
import com.globits.mita.ui.patients.SetLayoutListPatientFragment


class TreatmentFragment : MitaBaseFragment<FragmentTreatmentBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTreatmentBinding {
        return FragmentTreatmentBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutListPatientFragment(onClickListener = {
                (activity as TreatmentActivity).addFragmentInfoPatient()
            }, onBackStack = {(activity as TreatmentActivity).finish() })
        }
    }
}