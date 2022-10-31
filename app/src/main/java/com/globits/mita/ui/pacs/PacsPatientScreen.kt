package com.globits.mita.ui.pacs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.patients.SetLayoutItemPatient
import com.globits.mita.ui.patients.SetLayoutListDocument
import com.globits.mita.ui.patients.SetLayoutPatientInfo
import com.globits.mita.ui.patients.SetUpToolbarLayout
import com.globits.mita.ui.theme.BACKGROUND_TOOLBAR




@Preview
@Composable
fun DefaultPreviewPatientInfo() {
    SetLayoutPatientInfoPacs( onBackStack = {

    })
}



@Composable
fun SetLayoutPatientInfoPacs(onBackStack: () -> Unit) {
    Column(
        Modifier
            .background(Color.White)
    ) {
        SetUpToolbarLayout("Thông tin bệnh nhân",onBackStack)
        Column() {
            Box {
                Row(
                    Modifier
                        .background(BACKGROUND_TOOLBAR)
                        .fillMaxWidth()
                        .height(92.dp)
                ) {}
                Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp)) {
                    SetLayoutItemPatient(patient = UserDto("", "", "", 0),Modifier)
                }
            }
            SetLayoutListDocument()
        }
    }
}