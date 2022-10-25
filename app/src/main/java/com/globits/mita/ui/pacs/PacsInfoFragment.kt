package com.globits.mita.ui.pacs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentPACSBinding
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.patients.SetLayoutPatientInfoPacs

class PacsInfoFragment : MitaBaseFragment<FragmentPACSBinding>() {
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentPACSBinding {
        return FragmentPACSBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        views.content.setContent {
            SetLayoutPatientInfoPacs(){
                (activity as PacsActivity).addFragmentInfoPatient()
            }
        }
    }
}