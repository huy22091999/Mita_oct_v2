package com.globits.mita.ui.pacs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.R
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentAssignBinding
import com.globits.mita.ui.MainActivity
import com.globits.mita.ui.patients.SetLayoutListPatientFragmentAssign


class PacsFragment : MitaBaseFragment<FragmentAssignBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutListPatientFragmentAssign(onBackStack = {
                (activity as PacsActivity).finish()
            }, onClickListener = {
                (activity as PacsActivity).addFragmentInfoPatient()
            })


        }
    }

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAssignBinding {
        return FragmentAssignBinding.inflate(inflater, container, false)
    }

}