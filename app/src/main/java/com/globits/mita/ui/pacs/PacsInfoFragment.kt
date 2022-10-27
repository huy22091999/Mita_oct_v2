package com.globits.mita.ui.pacs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentPACSBinding
import com.globits.mita.ui.nursing.NursingActivity
import com.globits.mita.ui.patients.SetLayoutPatientInfoPacs

class PacsInfoFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfoPacs(){
            (activity as PacsActivity).addFragmentInfoPatient()
        }
    }


}