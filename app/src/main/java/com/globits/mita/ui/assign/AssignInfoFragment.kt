package com.globits.mita.ui.assign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentAssignBinding
import com.globits.mita.ui.patients.SetLayoutPatientInfoPacs


class AssignInfoFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfoAssign(){
            (activity as AssignActivity).removeBackStack()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}