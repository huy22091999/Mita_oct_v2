package com.globits.mita.ui.patients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.databinding.FragmentPatientInfoBinding


class PatientInfoFragment : MitaBaseFragment() {

    @Composable
    override fun SetLayout() {
        SetLayoutPatientActivity(){}
    }
}