package com.globits.mita.ui.pacs

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
import javax.inject.Inject


class PacsFragment @Inject constructor() : MitaBaseFragment() {

    val viewModel: PacsViewModel by activityViewModel()

    var valueState = mutableStateOf("Đang điều trị")


    @Composable
    override fun SetLayout() {

        val listPatient = viewModel.getPatient.collectAsLazyPagingItems()

        SetLayoutListPatientFragmentAssign(onBackStack = {
            (activity as PacsActivity).finish()
        }, onClickListener = {
            viewModel.handle(PacsViewAction.SetPatientDetail(it))
            (activity as PacsActivity).addFragmentInfoPatient()
        }, listUser = listPatient, getPatient = {
            viewModel.handle(PacsViewAction.GetPatients(it))
            valueState.value = if (it == 0) "Xem tất cả" else "Đang điều trị"
        },
            valueState = valueState
        )
    }

    override fun invalidate() = withState(viewModel) {

    }


}