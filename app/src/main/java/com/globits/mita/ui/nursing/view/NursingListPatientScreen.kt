package com.globits.mita.ui.nursing.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globits.mita.R
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.assign.view.SetLayoutPatientInfoItem
import com.globits.mita.ui.home.SetLayoutSearch
import com.globits.mita.ui.theme.*

@Preview
@Composable
fun DefaultPreviewListPatient() {
    SetLayoutListPatientFragment(onBackStack = {}, onClickListener = {})
}


@Composable
fun SetUpToolbarLayoutLight(onBackStack: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Danh sách bệnh nhân",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp), color = TEXT_BACK, textAlign = TextAlign.Center
            )
        },

        navigationIcon = {
            IconButton(
                onClick = {
                    onBackStack()
                }, Modifier
                    .background(
                        shape = RoundedCornerShape(12.dp),
                        color = Color.White
                    )
                    .height(44.dp)
                    .width(44.dp)
                    .border(
                        border = BorderStroke(1.dp, STROKE_COLOR_LIGHT),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Menu Btn", tint = TEXT_BACK
                )
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 0.dp,

        )
}

@Composable
fun SetHeaderListPatient() {
    Column {
        SetLayoutSearch(title = "Tìm kiếm bệnh nhân") {
        }
        var valueState by remember {
            mutableStateOf("Đang điều trị")
        }
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SetLayoutRadioButton(title = "Đang điều trị", valueState) {
                    valueState = it
                }
                SetLayoutRadioButton(title = "Xem tất cả", valueState) {
                    valueState = it
                }

            }
        }
    }
}

@Composable
fun SetLayoutRadioButton(title: String, valueState: String, onClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 16.dp)
    ) {
        RadioButton(
            selected = valueState == title,
            onClick = {
                onClick(title)
            },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = PRIMARY_COLOR
            )
        )
        Text(text = title)
    }
}

@Composable
fun SetBodyListPatient(onClickListener: (UserDto) -> Unit) {
    val listPatientInfo by remember {
        mutableStateOf(
            listOf<UserDto>(
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy"),
            )
        )
    }
    LazyColumn(contentPadding = PaddingValues(bottom = 16.dp), content = {
        items(listPatientInfo) { item ->
            SetLayoutItemPatient(patient = item, Modifier.clickable {
                onClickListener(item)
            })
        }
    })
}

@Composable
fun SetLayoutItemPatient(patient: UserDto, modifier: Modifier) {
    Card(
        modifier = Modifier

            .fillMaxWidth()
            .padding(bottom = 12.dp, top = 4.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)

    ) {
        Column(
            modifier
                .padding(16.dp)
                .border(width = 0.dp, color = Color.Transparent, RoundedCornerShape(12.dp))
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
            SetLayoutPatientInfoItem(patient)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_location_patient),
                    modifier = Modifier
                        .width(10.dp)
                        .height(10.dp)
                        .clickable {
                            println("icon click")
                        }, contentDescription = "", tint = ICON_LOCATION

                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "P. Vạn Mỹ, Q. Ngô Quyền, Hải Phòng",
                    style = styleText
                )
            }
        }


    }
}

