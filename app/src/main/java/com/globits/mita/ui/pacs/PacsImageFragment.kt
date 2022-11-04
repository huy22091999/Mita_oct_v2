package com.globits.mita.ui.pacs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.ui.assign.AssignViewModel
import com.globits.mita.ui.pacs.view.ImageScreen

class PacsImageFragment : MitaBaseFragment(){



    @Composable
    override fun SetLayout() {
       ImageScreen {
           (activity as PacsActivity).removeBackStack()
       }
    }


}