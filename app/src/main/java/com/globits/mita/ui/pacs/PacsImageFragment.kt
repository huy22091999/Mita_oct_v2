package com.globits.mita.ui.pacs

import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.ui.pacs.view.ImageScreen

class PacsImageFragment : MitaBaseFragment(){

    @Composable
    override fun SetLayout() {
       ImageScreen {
           (activity as PacsActivity).removeBackStack()
       }
    }
}