package com.globits.mita.ui.pacs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.ui.assign.AssignViewModel
import com.globits.mita.ui.pacs.view.SetLayoutPatientInfoPacs

class PacsInfoFragment : MitaBaseFragment() {

    val viewModel: PacsViewModel by activityViewModel()

    var patient = mutableStateOf<Patient>(Patient())

    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfoPacs(
            onBackStack = { (activity as PacsActivity).removeBackStack() },
            onClick = {(activity as PacsActivity).addFragmentImage()},
            patient = patient.value
        )
    }

    override fun invalidate(): Unit = withState(viewModel) {
        it.patient.also {
            if (it != null) {
                patient.value = it
            }
        }

    }

}