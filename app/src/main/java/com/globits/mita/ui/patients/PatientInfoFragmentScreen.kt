package com.globits.mita.ui.patients

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globits.mita.R
import com.globits.mita.ui.theme.*
import java.util.*

@Preview
@Composable
fun DefaultPreviewPatientInfo() {
    SetLayoutPatientInfo(true, onBackStack = {

    }, onPatientClick = {})
}

@Composable
fun SetLayoutPatientInfoPacs(onBackStack: () -> Unit) {
    Column(
        Modifier
            .background(Color.White)
    ) {
        SetUpToolbarLayout(onBackStack)
        Column() {
            Box {
                Row(
                    Modifier
                        .background(BACKGROUND_TOOLBAR)
                        .fillMaxWidth()
                        .height(92.dp)
                ) {}
                Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp)) {
                    SetLayoutItemPatient(patient = PatientInfo()) {
                    }
                }
            }
            SetLayoutListDocument()
        }
    }
}

@Composable
fun SetLayoutListDocument() {
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
        }

    }
}

@Composable
fun SetLayoutItemDoc(item: Doc) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .border(
                border = BorderStroke(1.dp, STROKE_BTN_FEATURE),
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
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
                    painterResource(id = R.drawable.img_icon_doc),
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

@Composable
fun SetLayoutPatientInfo(isNursing: Boolean, onPatientClick: () -> Unit, onBackStack: () -> Unit) {
    Column(
        Modifier
            .background(Color.White)
    ) {
        SetUpToolbarLayout(onBackStack)
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Box {
                Row(
                    Modifier
                        .background(BACKGROUND_TOOLBAR)
                        .fillMaxWidth()
                        .height(92.dp)
                ) {}
                Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp)) {
                    SetLayoutItemPatient(patient = PatientInfo()) {
                    }
                }
            }
            // chuẩn đoán
            SetLayoutDiagnostic()
            // danh sách chức năng
            SetUpListFeatureLayout(isNursing, onPatientClick)
        }


    }
}

@Composable
fun SetLayoutDiagnostic() {
    Column(Modifier.padding(start = 24.dp, end = 16.dp)) {
        Text(
            text = "Chuẩn đoán", fontSize = 17.sp,
            color = TEXT_BACK,
            style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_bold)))
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = "A10 - Đau bụng chưa rõ nguyên nhân; J11 - Tăng huyết áp vô căn",
            fontSize = 14.sp,
            color = TEXT_DOB,
            style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
        )
    }
}

@Composable
fun SetUpListFeatureLayout(isNursing: Boolean, onPatientClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 12.dp)
            .fillMaxWidth()
    ) {
        SetUpItemFeatureLayout(title = "Bệnh án", onPatientClick)
        SetUpItemFeatureLayout(title = "Ghi chú") {}
        if (isNursing) {
            SetUpItemFeatureLayout(title = "Tờ điều trị") {}
            SetUpItemFeatureLayout(title = "Chỉ định DVKT") {}
            SetUpItemFeatureLayout(title = "Kê đơn") {}
            SetUpItemFeatureLayout(title = "Công nợ") {}
            SetUpItemFeatureLayout(title = "PACS") {}
        } else {
            SetUpItemFeatureLayout(title = "Chăm sóc") {}
            SetUpItemFeatureLayout(title = "Chức năng sống") {}
            SetUpItemFeatureLayout(title = "Truyền dịch") {}
            SetUpItemFeatureLayout(title = "Thuốc, vật tư") {}
        }


    }
}

@Composable
fun SetUpItemFeatureLayout(title: String, onPatientClick: () -> Unit) {
    Column(modifier = Modifier
        .padding(bottom = 16.dp)
        .clickable { onPatientClick() }) {
        Row(
            modifier = Modifier
                .border(
                    border = BorderStroke(1.dp, STROKE_BTN_FEATURE),
                    shape = RoundedCornerShape(12.dp)
                )
                .fillMaxWidth()
                .padding()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title, fontSize = 16.sp,
                color = PRIMARY_COLOR,
                style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_bold)))
            )
            IconButton(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "Menu Btn", tint = PRIMARY_COLOR,
                )
            }
        }
    }
}

@Composable
fun SetUpToolbarLayout(onBackStack: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Thông tin bệnh nhân",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
            )
        },
        actions = {
            IconButton(
                onClick = {  }, Modifier
                    .background(
                        shape = RoundedCornerShape(12.dp),
                        color = BACKGROUND_TOOLBAR
                    )
                    .height(44.dp)
                    .width(44.dp)
                    .border(
                        border = BorderStroke(1.dp, STROKE_COLOR),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_link),
                    contentDescription = "Menu Btn",
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {onBackStack() }, Modifier
                    .background(
                        shape = RoundedCornerShape(12.dp),
                        color = BACKGROUND_TOOLBAR
                    )
                    .height(44.dp)
                    .width(44.dp)
                    .border(
                        border = BorderStroke(1.dp, STROKE_COLOR),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Menu Btn",
                )
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 0.dp,
        modifier = Modifier
            .background(BACKGROUND_TOOLBAR)
            .padding(start = 16.dp, end = 16.dp)
    )
}

data class Doc(
    val name: String? = null,
    val count: Int? = null,
    val date: Date? = null
)
