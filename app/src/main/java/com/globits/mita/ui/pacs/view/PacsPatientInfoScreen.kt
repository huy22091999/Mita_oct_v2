package com.globits.mita.ui.pacs.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globits.mita.R
import com.globits.mita.data.model.Patient
import com.globits.mita.ui.nursing.view.SetLayoutItemPatient
import com.globits.mita.ui.theme.*
import com.globits.mita.ui.treatment.view.Doc
import com.globits.mita.ui.treatment.view.SetUpToolbarLayout
import java.util.*


@Preview
@Composable
fun DefaultPreviewPatientInfo() {
    SetLayoutPatientInfoPacs(onBackStack = {
    }, onClick = {}, patient = Patient())
}


@Composable
fun SetLayoutPatientInfoPacs(onBackStack: () -> Unit, onClick: () -> Unit, patient: Patient) {
    Column(
        Modifier
            .background(Color.White)
    ) {
        SetUpToolbarLayout("Thông tin bệnh nhân", onBackStack)
        Column() {
            Box {
                Row(
                    Modifier
                        .background(BACKGROUND_TOOLBAR)
                        .fillMaxWidth()
                        .height(92.dp)
                ) {}
                Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp)) {
                    SetLayoutItemPatient(patient = patient,Modifier)
                }
            }
            SetLayoutListDocument()
            {
                onClick()
            }
        }
    }
}

@Composable
fun SetLayoutListDocument(onClick: () -> Unit) {
    val listDoc by remember {
        mutableStateOf(
            mutableListOf<Doc>(
                Doc(
                    "#ACC: 22344, Chụp cắt lớp vi tính khớp gối thẳng nghiêng 32 dãy", 6,
                    Date()
                ), Doc("#ACC: 22344, Chụp cắt lớp vi tính khớp gối thẳng nghiêng 32 dãy", 6, Date())
            )
        )
    }
    Text(
        modifier = Modifier.padding(start = 24.dp, end = 24.dp),
        text = "Danh sách tài liệu", fontSize = 14.sp,
        color = TEXT_DOB,
        style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_bold)))
    )
    LazyColumn(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        items(listDoc) { item ->
            SetLayoutItemDoc(item)
            {
                onClick()
            }
        }

    }
}

@Composable
fun SetLayoutItemDoc(item: Doc, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .border(
                width = 1.dp, color = STROKE_BTN_FEATURE, RoundedCornerShape(12.dp)
            )
            .clip(shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .width(56.dp)
                .height(56.dp), shape = RoundedCornerShape(12.dp), elevation = 0.dp
        ) {
            Row(
                modifier = Modifier.background(STROKE_BTN_FEATURE),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    painterResource(id = R.drawable.doc_new),
                    contentDescription = "image",
                    modifier = Modifier
                        .width(18.dp)
                        .height(24.dp)
                )
            }
        }

        Row(modifier = Modifier.padding(start = 8.dp)) {
            Column {
                item.name?.let {
                    Text(
                        text = it, fontSize = 16.sp,
                        color = BACKGROUND_TOOLBAR,
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)))
                    )
                }
                Text(
                    text = "${item.count} ảnh",
                    modifier = Modifier.padding(top = 4.dp),
                    fontSize = 14.sp,
                    color = TEXT_COLOR_IMG_NUM,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
                )
                Text(
                    text = "11/07/2022 | 02:00 PM",
                    modifier = Modifier.padding(top = 4.dp), fontSize =
                    16.sp,
                    color = TEXT_COLOR_IMG_TIME,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.img_three_dot),
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp)
                    .clickable {
                        println("icon click")
                    }, contentDescription = "", tint = COLOR_TEXT
            )
        }
    }
}