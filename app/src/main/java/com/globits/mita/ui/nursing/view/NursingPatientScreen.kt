package com.globits.mita.ui.nursing.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.globits.mita.data.model.Patient

@Preview
@Composable
fun DefaultPreviewNursingPatient() {
//    SetLayoutListPatientFragment(onBackStack = {}, onClickListener = {}, getPatient = {})


}

@Composable
fun SetLayoutListPatientFragment(
    onClickListener: (Patient) -> Unit,
    onBackStack: () -> Unit,
    getPatient: (filter :Int ) -> Unit,
    listUser: State<List<Patient>>
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
    ) {
        SetUpToolbarLayoutLight(onBackStack = onBackStack)
        SetHeaderListPatient() {
            getPatient(it)
        }
        SetBodyListPatient(onClickListener,listUser)
    }
}