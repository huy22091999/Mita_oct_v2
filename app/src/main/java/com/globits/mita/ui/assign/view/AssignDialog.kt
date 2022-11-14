package com.globits.mita.ui.assign.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.globits.mita.data.model.labtestassign.LabTestAssign
import com.globits.mita.data.model.labtestassign.LabTestAssignTemplate
import com.globits.mita.utils.formatNumber
import ir.kaaveh.sdpcompose.sdp


@Preview
@Composable
fun DefaultDiaLog() {
    var listLabTest = remember {
        mutableStateListOf(LabTestAssignTemplate())
    }

    var openDialog by remember { mutableStateOf(true) }
    CustomDialogScrollable(onDismiss = { openDialog },
        onConfirmClicked = {}, listLabTestTemplate = listLabTest)
}



@Composable
fun CustomDialogScrollable(
    onConfirmClicked: (listLabTestAssignTemplate: SnapshotStateList<LabTestAssignTemplate>) -> Unit,
    onDismiss: () -> Unit,
    listLabTestTemplate : SnapshotStateList<LabTestAssignTemplate>
) {

    val listLabTestAssignTemplate = remember {
        mutableStateListOf<LabTestAssignTemplate>()
    }



    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Surface(
            modifier = Modifier
                .padding(top = 24.sdp, bottom = 24.sdp)
                .border(width = 0.dp, color = Color.Transparent, shape = RoundedCornerShape(15.dp))
                .clip(shape = RoundedCornerShape(15.dp)),
            color = MaterialTheme.colors.surface,
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(weight = 1f, fill = false)
                        .padding(vertical = 16.dp)
                ) {

                    Text(
                        text = "Danh Sách Chỉ Định",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(modifier = Modifier.defaultMinSize(minHeight = 150.sdp), content = {
                        items(listLabTestTemplate)
                        {
                            ItemAssign(labTestAssignTemplate = it,listLabTestAssignTemplate)
                        }
                    })


                }

                // BUTTONS
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp), horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { onConfirmClicked(listLabTestAssignTemplate) }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}



@Composable
fun ItemAssign(
    labTestAssignTemplate: LabTestAssignTemplate,
    listLabTestAssignTemplate: SnapshotStateList<LabTestAssignTemplate>
) {
    var isCheck by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier
        .height(40.dp)
        .fillMaxWidth()
        .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(15.dp))
        .clip(shape = RoundedCornerShape(15.dp))
        .background(color = if (isCheck) Color.Yellow else Color.Transparent)
        .clickable {
            isCheck = !isCheck
            if (isCheck) {
                listLabTestAssignTemplate.add(labTestAssignTemplate)
            } else {
                listLabTestAssignTemplate.remove(labTestAssignTemplate)
            }
        }
        .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = labTestAssignTemplate.name.toString(),
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = formatNumber(labTestAssignTemplate.price!!.toInt()),
            fontWeight = FontWeight.SemiBold
        )

    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview
@Composable
fun DefaultItem() {
//    ItemAssign(labTestAssignTemplate = LabTestAssignTemplate())
}