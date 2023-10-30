package org.gangulwar.design2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {

    Box {
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .size(50.dp),
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = null,
                )
                Row(
                    Modifier
                        .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.location_pin),
                        contentDescription = null
                    )

                    Text(
                        text = "Los angeles, CA",
                        style = TextStyle(
                            fontFamily = rubikRegular,
                            fontSize = 15.sp,
                            color = Color(20, 54, 86)
                        ),
                        modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.down_arrow),
                        contentDescription = null
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.notification_bell),
                    contentDescription = null,
                    Modifier
                        .padding(end = 25.dp)
                        .size(30.dp)

                )

                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = null,
                    Modifier.size(30.dp),
                )
            }

            Column(
                modifier = Modifier.padding(35.dp)
            ) {

                Text(
                    text = "Hello Eddie!",
                    style = TextStyle(
                        color = Color(179, 179, 179),
                        fontSize = 20.sp,
                        fontFamily = rubikLight
                    )
                )


                Text(
                    text = "Start looking for your house",
                    style = TextStyle(
                        color = Color(20, 54, 86),
                        fontSize = 20.sp,
                        fontFamily = rubikLight
                    )
                )

                var name by remember { mutableStateOf("What are you looking for?") }

                TextField(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()
                        .shadow(elevation = 15.dp),
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(15.dp),
                    leadingIcon = {
                        Image(
                            modifier=Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null
                        )
                    }, trailingIcon = {
                        Image(
                            modifier=Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.filters),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview1() {
    // val navController = rememberNavController()
    //BottomNavigationBar(navController = navController)
    Home()
}
