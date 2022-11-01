package com.globits.mita.ui.treatment

import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.nursing.view.SetLayoutListPatientFragment


class TreatmentFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutListPatientFragment(onClickListener = {
            (activity as TreatmentActivity).addFragmentInfoPatient()
        }, onBackStack = {(activity as TreatmentActivity).finish() })
    }

}