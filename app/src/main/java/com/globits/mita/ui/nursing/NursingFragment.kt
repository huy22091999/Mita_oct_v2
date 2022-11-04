package com.globits.mita.ui.nursing

import android.os.Bundle
import android.view.View
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


class NursingFragment : MitaBaseFragment() {


    val viewModel: NursingViewModel by activityViewModel()

    var _listUser = mutableStateOf<List<Patient>>(mutableListOf())
    private val listUser: State<List<Patient>> = _listUser


    @Composable
    override fun SetLayout() {
        SetLayoutListPatientFragment(
            onClickListener = {
                (activity as NursingActivity).addFragmentInfoPatient()
                viewModel.handle(NursingViewAction.SetPatientDetail(it))
            },
            onBackStack = { (activity as NursingActivity).finish() },
            getPatient = {
                viewModel.handle(
                    NursingViewAction.GetPatients(
                        PatientFilter("", 1, 10, it)
                    )
                )
            },
            listUser
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun invalidate() = withState(viewModel) {
        updateState(it)
    }

    private fun updateState(it: NursingViewState) {
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