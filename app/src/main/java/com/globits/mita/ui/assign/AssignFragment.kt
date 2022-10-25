package com.globits.mita.ui.assign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentAssignBinding
import com.globits.mita.ui.patients.SetLayoutListPatientFragmentAssign


class AssignFragment : MitaBaseFragment<FragmentAssignBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAssignBinding {
        return FragmentAssignBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutListPatientFragmentAssign(onClickListener = {
                (activity as AssignActivity).addFragmentInfoPatient()
            }, onBackStack = {
                (activity as AssignActivity).finish()
            })


        }
    }

}