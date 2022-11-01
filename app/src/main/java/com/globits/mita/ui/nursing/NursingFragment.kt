package com.globits.mita.ui.nursing

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.nursing.view.SetLayoutListPatientFragment


class NursingFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutListPatientFragment(
            onClickListener = { (activity as NursingActivity).addFragmentInfoPatient() },
            onBackStack = { (activity as NursingActivity).finish() })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}