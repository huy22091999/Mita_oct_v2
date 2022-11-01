package com.globits.mita.ui.patients

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globits.mita.R
import com.globits.mita.ui.assign.view.SetLine
import com.globits.mita.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Preview
@Composable
fun PreviewLayout() {
    SetLayoutPatientActivity() {

    }
}

@Composable
fun SetLayoutPatientActivity(onBackStack: () -> Unit) {
    MaterialTheme() {
        Column() {
            Column(modifier = Modifier.background(PRIMARY_COLOR)) {
                SetUpToolbarLayout("Bệnh án", onBackStack)
                SetViewPagerLayout()
            }
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SetViewPagerLayout() {
    val tabData = listOf(
        "Xét nghiệm", "CĐHA", "Thuốc"
    )
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 3,
        infiniteLoop = true,
        initialPage = 0,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    // TAB
    TabRow(
        selectedTabIndex = tabIndex,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(20.dp)
            .border(
                width = 1.dp, color = Color.White, shape = RoundedCornerShape(10.dp)
            ), indicator = {
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabIndicatorOffset(it[tabIndex]),
                height = 0.dp,
                color = Color.Transparent
            )
        }, backgroundColor = Color.Transparent, contentColor = Color.Transparent
    ) {
        tabData.forEachIndexed { index, text ->
            Tab(
                selected = tabIndex == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = text,
                        color = if (tabIndex == index) PRIMARY_COLOR else Color.White,
                    )
                },
                modifier = Modifier
                    .clip(
                        shape = when (index) {
                            0 -> RoundedCornerShape(
                                topStart = 10.dp,
                                bottomStart = 10.dp,
                                topEnd = 0.dp,
                                bottomEnd = 0.dp
                            )
                            2 -> RoundedCornerShape(
                                topStart = 0.dp,
                                bottomStart = 0.dp,
                                topEnd = 10.dp,
                                bottomEnd = 10.dp
                            )
                            else -> RoundedCornerShape(
                                topStart = 0.dp,
                                bottomStart = 0.dp,
                                topEnd = 0.dp,
                                bottomEnd = 0.dp
                            )
                        }
                    )
                    .background(if (tabIndex == index) Color.White else PRIMARY_COLOR)
                    .border(
                        width = 0.5.dp,
                        Color.White,

                        )
                    .drawBehind {
                        drawLine(
                            Color.Blue,
                            Offset(size.width, 0f),
                            Offset(size.width, size.height),
                            4f
                        )
                    },
                selectedContentColor = Color.Transparent,
                unselectedContentColor = Color.Transparent,
            )
        }
    }
    HorizontalPager(
        state = pagerState, modifier = Modifier.background(Color.White)
    ) { index ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (tabData[index] == tabData[0]) {
                SetPatientSession0()
            } else if (tabData[index] == tabData[1]) {
                SetPatientSession1()
            } else {
                SetPatientSession2()
            }
        }
    }
}


fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val indicatorWidth = 32.dp
    val currentTabWidth = currentTabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}

@Composable
fun SetPatientSession0() {
    val specials = remember {
        mutableStateListOf<String>(
            "Chụp Xquang số hóa 1 film",
            "Chụp Xquang số hóa 1 film",
        )
    }
    LazyColumn {
        items(specials) {
            SetItemPatient {
                ContentLabTest()
            }
        }
    }
}

@Composable
fun SetPatientSession1() {
    val specials = remember {
        mutableStateListOf<String>(
            "Chụp Xquang số hóa 1 film",
            "Chụp Xquang số hóa 1 film",
        )
    }
    LazyColumn {
        items(specials) {
            SetItemPatient {
                ContentCDHA()
            }
        }
    }
}

@Composable
fun SetPatientSession2() {
    val specials = remember {
        mutableStateListOf<String>(
            "Chụp Xquang số hóa 1 film",
            "Chụp Xquang số hóa 1 film",
        )
    }
    LazyColumn {
        items(specials) {
            SetItemPatient {
                ContentMedicine()
            }
        }
    }
}

@Composable
fun SetItemPatient(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp, start = 20.dp, end = 20.dp),
        border = BorderStroke(color = PATIENT_BACKGROUND, width = 1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PATIENT_BACKGROUND)
            ) {
                Text(
                    text = "Ngày chỉ định: 01/10/2022", fontSize = 16.sp,
                    style = TextStyle(fontFamily = FontFamily(Font(R.font.nunito_sans_semi_bold))),
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp
                        )
                        .fillMaxWidth(), textAlign = TextAlign.Center, color = Color.White
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Khoa/Phòng chỉ định",
                        style = styleText1
                    )
                    Text(
                        text = "Người chỉ định",
                        style = styleText1
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp, bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Khoa Nội tim mạch Lão khoa",
                        style = styleText2
                    )
                    Text(
                        text = "BS.Phạm Thị Hiền",
                        style = styleText1
                    )
                }

                var visible by remember {
                    mutableStateOf(true)
                }
                this@Column.AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(
                        // Overwrites the initial value of alpha to 0.4f for fade in, 0 by default
                        initialAlpha = 0.4f
                    ),
                    exit = fadeOut(
                        // Overwrites the default animation with tween
                        animationSpec = tween(durationMillis = 250)
                    )
                ) {
                    // Content that needs to appear/disappear goes here:
                    Column() {

                        content()
                        SetLine()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp)
                                .clickable {
                                    visible = false
                                },
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Thu gon",
                                style = styleText1,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Icon(
                                modifier = Modifier
                                    .width(10.dp)
                                    .height(10.dp),
                                painter = painterResource(id = R.drawable.img_icon_hidden),
                                contentDescription = "icon", tint = PRIMARY_COLOR
                            )
                        }
                    }

                }
                this@Column.AnimatedVisibility(
                    visible = !visible,
                    enter = fadeIn(
                        // Overwrites the initial value of alpha to 0.4f for fade in, 0 by default
                        initialAlpha = 0.4f
                    ),
                    exit = fadeOut(
                        // Overwrites the default animation with tween
                        animationSpec = tween(durationMillis = 250)
                    )
                ) {
                    // Content that needs to appear/disappear goes here:
                    SetLine()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                            .clickable {
                                visible = true
                            },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Chi tiết",
                            style = styleText1,
                            modifier = Modifier.padding(end = 10.dp),
                            fontSize = 14.sp
                        )
                        Icon(
                            modifier = Modifier
                                .width(10.dp)
                                .height(10.dp),
                            painter = painterResource(id = R.drawable.img_icon_show),
                            contentDescription = "icon", tint = PRIMARY_COLOR
                        )
                    }
                }
            }

        }

    }

}

@Composable
fun SetLayoutTitle(text: String) {
    Row(
        modifier = Modifier
            .background(BACKGROUND_TEXT)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text.uppercase(),
            style = styleText1,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
        )
    }
}


@Composable
fun ContentLabTest() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetLayoutTitle("XÉT NGHIỆM HUYẾT HỌC")
        SetLayoutResultLabTest()
        Text(
            text = "Tổng phân tích tế bào máu ngoại vi",
            style = styleText1, fontSize = 14.sp,

            )
        Text(
            text = "(Bằng máy đếm tổng trở)",
            style = styleText2, fontSize = 14.sp,
            color = PRIMARY_COLOR
        )
    }

    SetItemLabTest(text = "MCH (Lượng HGB trung bình HC)")

}

@Composable
fun SetLayoutResultLabTest() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(top = 4.dp, bottom = 2.dp),
            text = "Ngày trả KQ",
            style = styleText1
        )
        Text(
            text = "Người trả KQ",
            style = styleText1
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "01/10/2022",
            style = styleText2
        )
        Text(
            text = "BS.Phạm Thị Hiền",
            style = styleText2
        )
    }
}

@Composable
fun ContentCDHA() {
    SetLayoutTitle(text = "CHụp X-quang")
    SetLayoutResultLabTest()
    SetItemCDHD("Chụp Xquang cột sống thắt lưng thẳng nghiêng")

    SetLayoutTitle(text = "Siêu âm")
    SetLayoutResultLabTest()
    SetItemCDHD("Chụp Xquang cột sống thắt lưng thẳng nghiêng")
}

@Composable
fun ContentMedicine() {
    SetItemMedicine("Acetyl leucin(Vintanil 1000) 100mg/ml x 10ml")
}

@Composable
fun SetItemMedicine(text: String) {
    Card(
        modifier = Modifier.padding(top = 12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding()
                .background(BACKGROUND_ITEM_LAB_TEST)
                .padding(16.dp)
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontStyle = FontStyle(R.font.nunito_sans_semi_bold)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Kết quả",
                    style = styleText1
                )
                Text(
                    text = "Giá trị tham chiếu",
                    style = styleText1
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "134 g/l",
                    style = styleText2,
                )
                Text(
                    text = "80 - 120",
                    style = styleText2
                )
            }
            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 2.dp),
                text = "Kết quả",
                style = styleText1
            )
            Text(
                text = "Giá trị tham chiếu",
                style = styleText2
            )
        }
    }
}

@Composable
fun SetItemLabTest(text: String) {
    Card(
        modifier = Modifier.padding(top = 12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding()
                .background(BACKGROUND_ITEM_LAB_TEST)
                .padding(16.dp)
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontStyle = FontStyle(R.font.nunito_sans_semi_bold)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Kết quả",
                    style = styleText1
                )
                Text(
                    text = "Giá trị tham chiếu",
                    style = styleText1
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "134 g/l",
                    style = styleText2,
                )
                Text(
                    text = "80 - 120",
                    style = styleText2
                )
            }

        }
    }

}

@Composable
fun SetItemCDHD(text: String) {
    Card(
        modifier = Modifier.padding(top = 12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .padding()
                .background(BACKGROUND_ITEM_LAB_TEST)
                .padding(16.dp)
        ) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontStyle = FontStyle(R.font.nunito_sans_semi_bold)
            )
            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 2.dp),
                text = "Kết quả",
                style = styleText1
            )
            Text(
                text = "Giá trị tham chiếu",
                style = styleText2
            )
        }
    }
}




