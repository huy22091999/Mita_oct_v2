package com.globits.mita.ui.patients

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.globits.mita.ui.theme.*
import java.util.*


@Preview
@Composable
fun DefaultPreviewListPatientAssign() {
//    SetLayoutListPatientFragmentAssign(onClickListener = {}, onBackStack = {}, listUser = mutableStateOf(
//        mutableListOf<UserDto>())
}

@Composable
fun SetLayoutListPatientFragmentAssign(
    listUser: androidx.compose.runtime.State<List<UserDto>>,
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
        SetBodyListPatientAssign(listUser, onClickListener)
    }
}


@Composable
fun SetBodyListPatientAssign(
    listUser: androidx.compose.runtime.State<List<UserDto>>,
    onClickListener: (UserDto) -> Unit
) {
    val listPatientInfo by remember {
        mutableStateOf(
            mutableListOf<UserDto>(
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy"),
                UserDto(name = "Nguyễn văn Huy")
            )
        )
    }
    LazyColumn(content = {
        items(listUser.value) { item ->
            SetLayoutItemPatientAssign(patient = item) {
                onClickListener(item)
            }
        }
    })
}

@Composable
fun SetLayoutItemPatientAssign(patient: UserDto, onClickPatient: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp, top = 4.dp)
            .clickable { onClickPatient() },
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            SetLayoutPatientInfoItem(patient)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_icon_file),
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

data class PatientInfo(
    val id: String? = null,
    val code: String? = null,
    val dob: Date? = null,
    val gender: String? = null,
    val status: String? = null,
    val address: String? = null,
)

