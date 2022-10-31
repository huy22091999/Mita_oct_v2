package com.globits.mita.ui.pacs

import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment

class PacsInfoFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfoPacs() {
            (activity as PacsActivity).removeBackStack()
        }
    }


}