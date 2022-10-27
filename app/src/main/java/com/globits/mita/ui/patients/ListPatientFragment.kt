package com.globits.mita.ui.patients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.globits.mita.R
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentListPatientBinding
import com.globits.mita.ui.MainActivity
import com.globits.mita.ui.nursing.SetLayoutListPatientFragment


class ListPatientFragment : MitaBaseFragment() {

    @Composable
    override fun SetLayout() {
        SetLayoutListPatientFragment(onBackStack = {
        }, onClickListener = {
            (activity as MainActivity).navigateTo(R.id.action_listPatientFragment_to_patientInfoFragment)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}