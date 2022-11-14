package com.globits.mita.ui.treatment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.paging.compose.collectAsLazyPagingItems
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.ui.nursing.view.SetLayoutListPatientFragment


class TreatmentFragment : MitaBaseFragment() {


    val viewModel: TreatmentViewModel by activityViewModel()

    var valueState = mutableStateOf("Đang điều trị")

    @Composable
    override fun SetLayout() {

        val listPatient = viewModel.getPatient.collectAsLazyPagingItems()

        SetLayoutListPatientFragment(onClickListener = {
            (activity as TreatmentActivity).addFragmentInfoPatient()
            viewModel.handle(TreatmentViewAction.SetPatientDetail(it))
        }, onBackStack = { (activity as TreatmentActivity).finish() },
            getPatient = {
                viewModel.handle(
                    TreatmentViewAction.GetPatients(it)
                )
                valueState.value = if (it == 0) "Xem tất cả" else "Đang điều trị"
            },
            listPatient,
            valueState
        )

    }


    override fun invalidate() = withState(viewModel) {
    }


}