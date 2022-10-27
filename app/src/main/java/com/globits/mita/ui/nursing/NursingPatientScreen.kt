package com.globits.mita.ui.nursing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.globits.mita.ui.patients.*

@Preview
@Composable
fun DefaultPreviewNursingPatient() {
    SetLayoutListPatientFragment(onBackStack = {}, onClickListener = {})


}
@Composable
fun SetLayoutListPatientFragment(onClickListener: (PatientInfo) -> Unit, onBackStack: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
    ) {
        SetUpToolbarLayoutLight(onBackStack = onBackStack)
        SetHeaderListPatient()
        SetBodyListPatient(onClickListener)
    }
}