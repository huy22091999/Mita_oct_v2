package com.globits.mita.ui.pacs

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
import com.globits.mita.ui.assign.view.SetLayoutListPatientFragmentAssign
import com.globits.mita.utils.snackbar
import javax.inject.Inject


class PacsFragment @Inject constructor() : MitaBaseFragment() {

    val viewModel: PacsViewModel by activityViewModel()

    var valueState = mutableStateOf("Đang điều trị")

    var _listUser = mutableStateOf<List<Patient>>(mutableListOf())
    private val listUser: State<List<Patient>> = _listUser

    @Composable
    override fun SetLayout() {
        SetLayoutListPatientFragmentAssign(onBackStack = {
            (activity as PacsActivity).finish()
        }, onClickListener = {
            viewModel.handle(PacsViewAction.SetPatientDetail(it))
            (activity as PacsActivity).addFragmentInfoPatient()
        }, listUser = listUser, getPatient = {
            viewModel.handle(PacsViewAction.GetPatients(PatientFilter("", 1, 10, it)))
            valueState.value = if (it == 0) "Xem tất cả" else "Đang điều trị"
        },
            valueState = valueState
        )
    }

    override fun invalidate() = withState(viewModel) {
        updateState(it)
    }

    private fun updateState(it: PacsViewState) {
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