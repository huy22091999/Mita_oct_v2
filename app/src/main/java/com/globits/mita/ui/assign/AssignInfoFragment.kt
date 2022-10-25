package com.globits.mita.ui.assign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentAssignBinding
import com.globits.mita.ui.patients.SetLayoutPatientInfoPacs


class AssignInfoFragment : MitaBaseFragment<FragmentAssignBinding>() {
    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAssignBinding {
        return FragmentAssignBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutPatientInfoAssign(){
                (activity as AssignActivity).removeBackStack()
            }
        }
    }

}