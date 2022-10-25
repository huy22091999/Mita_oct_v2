package com.globits.mita.ui.patients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.R
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentListPatientBinding
import com.globits.mita.ui.MainActivity


class ListPatientFragment : MitaBaseFragment<FragmentListPatientBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListPatientBinding {
        return FragmentListPatientBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutListPatientFragment(onBackStack = {
            }, onClickListener = {
                (activity as MainActivity).navigateTo(R.id.action_listPatientFragment_to_patientInfoFragment)
            })


        }
    }

}