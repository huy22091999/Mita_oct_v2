package com.globits.mita.ui.treatment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.model.Patient
import com.globits.mita.data.model.PatientFilter
import com.globits.mita.ui.nursing.view.SetLayoutListPatientFragment
import com.globits.mita.utils.snackbar


class TreatmentFragment : MitaBaseFragment() {



    val viewModel: TreatmentViewModel by activityViewModel()

    var valueState = mutableStateOf("Đang điều trị")

    var _listUser = mutableStateOf<List<Patient>>(mutableListOf())
    private val listUser: State<List<Patient>> = _listUser

    @Composable
    override fun SetLayout() {
        SetLayoutListPatientFragment(onClickListener = {
            (activity as TreatmentActivity).addFragmentInfoPatient()
            viewModel.handle(TreatmentViewAction.SetPatientDetail(it))
        }, onBackStack = { (activity as TreatmentActivity).finish() },
            getPatient = {
                viewModel.handle(
                    TreatmentViewAction.GetPatients(
                        PatientFilter("", 1, 10, it)
                    )
                )
                valueState.value = if (it == 0) "Xem tất cả" else "Đang điều trị"
            },
            listUser,
            valueState
        )

    }


    override fun invalidate() = withState(viewModel) {
        updateState(it)
    }

    private fun updateState(it: TreatmentViewState) {
        when (it.asyncPatients) {
            is Success -> {
                it.asyncPatients.invoke()?.let {
                    if (it != null) {
                        //_listUser.value=it
                        _listUser.value = it.content!!
                    }
                }
            }
            is Fail -> {
                requireActivity().snackbar("Đã xảy ra lỗi xin vui lòng thử lại.")
            }
            else -> {}

        }
    }

}