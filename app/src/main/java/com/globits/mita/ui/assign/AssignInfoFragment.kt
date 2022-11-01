package com.globits.mita.ui.assign

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.assign.view.SetLayoutPatientInfoAssign


class AssignInfoFragment : MitaBaseFragment() {
    @Composable
    override fun SetLayout() {
        SetLayoutPatientInfoAssign(onBackStack = {
            (activity as AssignActivity).removeBackStack()
        }, UserDto(name = "Nguyễn văn Huy"))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}