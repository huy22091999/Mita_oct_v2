package com.globits.mita.ui.pacs.view

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.assign.view.SetLayoutListPatientFragmentAssign


@Preview
@Composable
fun DefaultPreviewListPatient() {

    var listUser:MutableState<List<UserDto>> = remember {
        mutableStateOf<List<UserDto>>(
            mutableListOf(
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy")
            )
        )
    }

    SetLayoutListPatientFragmentAssign(onBackStack = {

    }, onClickListener = {

    }, listUser = listUser
    )

}