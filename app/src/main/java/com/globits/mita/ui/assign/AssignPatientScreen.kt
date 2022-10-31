package com.globits.mita.ui.assign

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globits.mita.R
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.patients.SetLayoutDiagnostic
import com.globits.mita.ui.patients.SetLayoutItemPatient
import com.globits.mita.ui.patients.SetUpToolbarLayout
import com.globits.mita.ui.theme.*
import com.globits.mita.utils.ExposedDropdownMenu
import com.globits.mita.utils.formatNumber


@Preview
@Composable
fun DefaultPreviewPatientInfoAssign() {
    SetLayoutPatientInfoAssign(onBackStack = {},UserDto(name = "Nguyễn văn Huy"))
}

@Composable
fun SetLayoutPatientInfoAssign(onBackStack: () -> Unit,userDto: UserDto) {
    MaterialTheme {
        Column(
            Modifier
                .background(Color.White)
        ) {
            SetUpToolbarLayout("Thông tin bệnh nhân",onBackStack)
            Column(
                Modifier
//                    .fillMaxHeight()
//                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Box {
                    Row(
                        Modifier
                            .background(BACKGROUND_TOOLBAR)
                            .fillMaxWidth()
                            .height(92.dp)
                    ) {}
                    Column(Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp)) {
                        SetLayoutItemPatient(patient =userDto,Modifier)
                    }
                }
                SetLayoutDiagnostic()
                SetLayoutListAssign()
            }
        }
    }

}

@Composable
fun SetLayoutListAssign() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 20.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 16.dp)
        ) {
            var radioButtonClick by remember {
                mutableStateOf(true)
            }
            RadioButton(
                selected = radioButtonClick,
                onClick = {
                    radioButtonClick = !radioButtonClick
                },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = PRIMARY_COLOR
                )
            )
            Text(text = "Cấp cứu")
        }
        Text(
            text = "Danh sách phiếu chỉ định", fontSize = 17.sp,
            color = TEXT_BACK,
            style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_bold)))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 24.dp)
        ) {
            ExposedDropdownMenu(
                listOf("Đơn mẫu", "Default"),
                Modifier
                    .fillMaxWidth(.5f)
                    .padding(end = 12.dp)
            )
            ExposedDropdownMenu(listOf("Chọn tờ điều trị", "Default"), Modifier.fillMaxWidth())
        }

        SetLine()
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Phiếu chỉ định", fontSize = 17.sp,
            color = TEXT_BACK,
            style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_bold)))
        )
        val iconStart: @Composable (() -> Unit) = {
            Icon(
                painter = painterResource(id = R.drawable.img_search),
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp), contentDescription = "", tint = COLOR_TEXT
            )
        }
        var textSearch by remember {
            mutableStateOf("")
        }
        TextField(
            value = textSearch,
            placeholder = { Text(text = "Tìm kiếm dịch vụ", color = COLOR_TEXT) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onValueChange = { textSearch = it },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = BACKGROUND_EDIT_TEXT
            ),
            shape = RoundedCornerShape(16.dp),
            leadingIcon = iconStart,
        )
        val specials = remember {
            mutableStateListOf<Special>(
                Special(
                    "Chụp Xquang số hóa 1 film",
                    1000
                ), Special(
                    "Chụp Xquang số hóa 1 film",
                    1000
                )
            )
        }
//        LazyColumn(Modifier.padding(top = 16.dp)) {
//            items(specials) { item ->
//                SetLayoutItemSpecial(item)
//            }
//        }
        Column(Modifier.padding(top = 16.dp)) {
            for (item in specials) {
                SetLayoutItemSpecial(item)
            }
        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .padding(bottom = 40.dp)
                .fillMaxWidth(), colors =
            ButtonDefaults.buttonColors(BACKGROUND_BUTTON),
            shape = RoundedCornerShape(16.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                modifier = Modifier
                    .width(14.dp)
                    .height(14.dp), contentDescription = "", tint = TEXT_COLOR3

            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Thêm chỉ định", color = TEXT_COLOR3,
                style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)))
            )
        }
        SetLine()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {

            Text(
                text = "Tổng tiền", fontSize = 16.sp,
                color = TEXT_COLOR1,
                style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
            )

            Text(
                text = "${formatNumber(10000000)} VNĐ", fontSize = 16.sp,
                color = TEXT_COLOR2,
                style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
            )

        }
        Row(modifier = Modifier.padding(top = 40.dp)) {
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(start = 6.dp, end = 6.dp)
                    .fillMaxWidth(.5f), colors =
                ButtonDefaults.buttonColors(PRIMARY_COLOR),
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(
                    text = "Lưu", color = Color.White,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)))
                )
            }
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(start = 6.dp, end = 6.dp)
                    .fillMaxWidth(), colors =
                ButtonDefaults.buttonColors(PRIMARY_COLOR),
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(
                    text = "Lưu + Kí số", color = Color.White,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold)))
                )
            }

        }

    }

}

@Composable
fun SetLine() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(STROKE_COLOR_LINE)
    ) {}
}

@Composable
fun SetLayoutItemSpecial(item: Special) {
    Row(
        modifier = Modifier
            .padding(bottom = 12.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .width(16.dp)
                .height(16.dp),
            painter =
            painterResource(id = R.drawable.img_icon_remove_item),
            contentDescription = "icon"
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            item.name?.let {
                Text(
                    text = it, fontSize = 16.sp,
                    color = TEXT_COLOR1,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
                )
            }
            item.price?.let {
                Text(
                    text = formatNumber(item.price), fontSize = 16.sp,
                    color = TEXT_COLOR2,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
                )
            }
        }

    }
}

data class Special(
    val name: String? = null,
    val price: Int? = null
)