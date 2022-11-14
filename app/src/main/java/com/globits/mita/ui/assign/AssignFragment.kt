package com.globits.mita.ui.assign

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.paging.compose.collectAsLazyPagingItems
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.ui.assign.view.SetLayoutListPatientFragmentAssign
import com.globits.mita.utils.snackbar


class AssignFragment : MitaBaseFragment() {

    val viewModel: AssignViewModel by activityViewModel()

    var valueState = mutableStateOf("Đang điều trị")



    @Composable
    override fun SetLayout() {

        val listPatient = viewModel.getPatient.collectAsLazyPagingItems()

        SetLayoutListPatientFragmentAssign(onClickListener = {
            viewModel.handle(AssignViewAction.SetPatientDetail(it))
            (activity as AssignActivity).addFragmentInfoPatient()

        }, onBackStack = {
            (activity as AssignActivity).finish()
        }, listUser = listPatient,
            getPatient = {
                viewModel.handle(AssignViewAction.GetPatients(it))
                valueState.value = if (it == 0) "Xem tất cả" else "Đang điều trị"
            },
            valueState = valueState
        )


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun invalidate() = withState(viewModel) {

    }


}