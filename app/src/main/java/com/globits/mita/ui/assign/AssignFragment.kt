package com.globits.mita.ui.assign

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
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.patients.SetLayoutListPatientFragmentAssign
import com.globits.mita.utils.snackbar
import javax.inject.Inject


class AssignFragment @Inject constructor() : MitaBaseFragment() {
    val viewModel: AssignViewModel by activityViewModel()

    var _listUser = mutableStateOf<List<UserDto>>(mutableListOf())
    private val listUser: State<List<UserDto>> = _listUser

    @Composable
    override fun SetLayout() {

        SetLayoutListPatientFragmentAssign(onClickListener = {
            (activity as AssignActivity).addFragmentInfoPatient()
        }, onBackStack = {
            (activity as AssignActivity).finish()
        }, listUser =listUser)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun invalidate() = withState(viewModel) {
        updateState(it)
    }

    private fun updateState(it: AssignViewState) {
        when (it.asyncUsers) {
            is Success -> {
                it.asyncUsers.invoke()?.data.let {
                    if (it != null) {
                        _listUser.value=it
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