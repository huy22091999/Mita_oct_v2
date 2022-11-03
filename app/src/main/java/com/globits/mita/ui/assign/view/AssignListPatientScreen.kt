package com.globits.mita.ui.assign.view

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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.globits.mita.R
import com.globits.mita.data.network.UserDto
import com.globits.mita.ui.nursing.view.SetHeaderListPatient
import com.globits.mita.ui.nursing.view.SetUpToolbarLayoutLight
import com.globits.mita.ui.theme.*

@Preview
@Composable
fun DefaultListPatient() {
    var listUser: MutableState<List<UserDto>> = remember {
        mutableStateOf<List<UserDto>>(
            mutableListOf(
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy")
            )
        )
    }
    SetLayoutListPatientFragmentAssign(onClickListener = {

    }, onBackStack = {

    }, listUser = listUser)
}

@Composable
fun  SetLayoutListPatientFragmentAssign(
    listUser: State<List<UserDto>>?,
    onClickListener: (UserDto) -> Unit,
    onBackStack: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.White)
    ) {
        SetUpToolbarLayoutLight(onBackStack = onBackStack)
        SetHeaderListPatient()
        if (listUser != null) {
            SetBodyListPatientAssign(listUser, onClickListener)
        }
    }
}


@Composable
fun SetBodyListPatientAssign(
    listUser: State<List<UserDto>>,
    onClickListener: (UserDto) -> Unit
) {

    LazyColumn(content = {
        items(listUser.value) { item ->
            SetLayoutItemPatientAssign(patient = item, Modifier.clickable {
                onClickListener(item)
            })
        }
    })
}

@Composable
fun SetLayoutItemPatientAssign(patient: UserDto, modifier: Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp, top = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier
                .padding(16.dp)
        ) {
            SetLayoutPatientInfoItem(patient)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
            ) {
                Icon(
                    painter = painterResource(id = com.globits.mita.R.drawable.img_icon_file),
                    modifier = Modifier
                        .width(14.dp)
                        .height(14.dp)
                        .padding(top = 4.dp),
                    contentDescription = "",
                    tint = ICON_LOCATION

                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "#ACC: 22344, Chụp cắt lớp vi tính khớp gối thẳng nghiêng 32 dãy",
                    style = styleText
                )
            }
        }


    }
}

@Composable
fun SetLayoutPatientInfoItem(patient: UserDto) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 0.dp, color = Color.Transparent,RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        val (layoutImage, layoutText) = createRefs()
        Image(
            painterResource(id = R.drawable.img_patient), "Avatar",
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .constrainAs(layoutImage) {
                    start.linkTo(parent.start)
                }
                .fillMaxSize(),
        )
        Column(
            modifier = Modifier
                .constrainAs(layoutText) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(start = 52.dp)
                .fillMaxWidth()
        ) {

            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val (name, btn) = createRefs()
                patient.name?.let {
                    Text(text = it, modifier = Modifier
                        .constrainAs(name) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                        .padding(end = 32.dp),
                        fontSize = 18.sp,
                        style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold))))
                }
                Image(
                    painterResource(id = R.drawable.img_three_dot), "Avatar",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .constrainAs(btn) {
                            end.linkTo(parent.end)
                        },
                )
            }
            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val (dob, status) = createRefs()
                Text(
                    text = "Sinh năm 2000 | 22 tuổi | Nam",
                    modifier = Modifier.constrainAs(dob) {
                        start.linkTo(parent.start)
                    },
                    fontSize = 10.sp,
                    color = TEXT_DOB,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
                )
                Text(
                    text = buildAnnotatedString {
                        append("\u2022 Đang điều trị")

                    }, modifier = Modifier.constrainAs(status) {
                        start.linkTo(dob.end)
                        end.linkTo(parent.end)
                    }, fontSize = 10.sp, color = TEXT_STATUS,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_regular)))
                )
            }
        }

    }
    Row(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(.5f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.img_code_patient),
                modifier = Modifier
                    .width(13.dp)
                    .height(10.dp)
                    .clickable {
                        println("icon click")
                    }, contentDescription = "", tint = ICON_CODE_PATIENT

            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "Mã BN:22000022",
                style = styleText
            )
        }
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_flag_patient),
                    modifier = Modifier
                        .width(13.dp)
                        .height(13.dp)
                        .clickable {
                            println("icon click")
                        }, contentDescription = "", tint = ICON_FLAG

                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "Đối tượng: Viện phí",
                    style = styleText
                )
            }
        }


    }
}

