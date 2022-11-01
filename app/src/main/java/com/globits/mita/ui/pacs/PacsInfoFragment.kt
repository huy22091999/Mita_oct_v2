package com.globits.mita.ui.pacs

import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.pacs.view.SetLayoutPatientInfoPacs

class PacsInfoFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfoPacs() {
            (activity as PacsActivity).removeBackStack()
        }
    }


}