package com.globits.mita.ui.pacs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.globits.mita.core.MitaBaseFragment
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.assign.view.SetLayoutListPatientFragmentAssign


class PacsFragment : MitaBaseFragment() {
    var _listUser = mutableStateOf<List<UserDto>>(
        mutableListOf(
            UserDto(name = "Nguyễn văn Huy"),
            UserDto(name = "Nguyễn văn Huy"),
            UserDto(name = "Nguyễn văn Huy"),
            UserDto(name = "Nguyễn văn Huy")
        )
    )
    private val listUser: State<List<UserDto>> = _listUser

    @Composable
    override fun SetLayout() {
        SetLayoutListPatientFragmentAssign(onBackStack = {
            (activity as PacsActivity).finish()
        }, onClickListener = {
            (activity as PacsActivity).addFragmentInfoPatient()
        }, listUser = listUser
        )
    }
}