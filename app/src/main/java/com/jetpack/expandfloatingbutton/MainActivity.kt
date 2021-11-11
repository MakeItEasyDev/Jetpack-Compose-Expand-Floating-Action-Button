package com.jetpack.expandfloatingbutton

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.expandfloatingbutton.ui.theme.ExpandFloatingButtonTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandFloatingButtonTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ExpandFloatingButton()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ExpandFloatingButton() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Expand Floating Action Button",
                        color = Color.White,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        },

        floatingActionButton = {
            MultiFloatingActionButton(
                items = listOf(
                    MultiFabItem(
                        id = 1,
                        iconRes = R.drawable.ic_outline_person_add_24,
                        label = "Add User"
                    ),
                    MultiFabItem(
                        id = 2,
                        iconRes = R.drawable.ic_outline_group_add_24,
                        label = "Create Group"
                    ),
                    MultiFabItem(
                        id = 3,
                        iconRes = R.drawable.ic_outline_video_call_24,
                        label = "Video Call"
                    )
                ),
                fabIcon = FabIcon(iconRes = R.drawable.ic_baseline_add_24, iconRotate = 45f),
                onFabItemClicked = {
                    Toast.makeText(context, it.label, Toast.LENGTH_SHORT).show()
                },
                fabOption = FabOption(
                    iconTint = Color.White,
                    showLabel = true
                )
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(20) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(10.dp, 5.dp, 10.dp, 5.dp)
                            .background(Color.White),
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(5.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cat),
                                    contentDescription = "Item Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                )

                                Spacer(modifier = Modifier.padding(5.dp))

                                Column {
                                    Text(
                                        text = "Make it Easy ${index + 1}",
                                        color = Color.Black,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.padding(2.dp))

                                    Text(
                                        text = "Lorem Ipsum is simply Item ${index + 1}",
                                        color = Color.Gray,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}























