package org.gangulwar.design2

import android.app.Activity
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

val rubikRegular = FontFamily(
    Font(R.font.rubik_regular)
)

val rubikLight = FontFamily(
    Font(R.font.rubik_light)
)

val rubikMedium = FontFamily(
    Font(R.font.rubik_medium)
)

@Composable
fun LoginScreen(
    navHostController: NavController, onClick: () -> Unit
) {
    val activity = LocalView.current.context as Activity
    val backgroundArgb = colorResource(id = R.color.login_screen_bg).toArgb()
    activity.window.statusBarColor = backgroundArgb

    Box(
        modifier = Modifier
            .fillMaxSize()
//        .background(Color(R.color.login_screen_bg))
            .background(Color(70, 208, 217)),
        contentAlignment = Alignment.Center
    ) {

        Column {
            Image(
                painterResource(id = R.drawable.find_home),
                contentDescription = null,
                Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth()
                    .size(125.dp),
                alignment = Alignment.Center,
            )

            Login(onClick)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(onClick: () -> Unit) {

    var text by remember { mutableStateOf("mauricio@divelement.io") }
    var password by remember { mutableStateOf("123456789") }
    var fontColor = colorResource(id = R.color.font_color)

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 35.dp), Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.triangle),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontFamily = rubikMedium,
                    color = fontColor
                )
            )

            Text(
                text = "Login to enjoy findhome",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = rubikLight,
                    color = Color(0, 0, 0, 50)
                )
            )

            Text(
                text = "Email",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 25.dp),
                style = TextStyle(
                    fontFamily = rubikRegular,
                    fontSize = 15.sp, color = Color(19, 73, 123)
                )
            )


            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = rubikRegular,
                    color = Color(0, 0, 0, 100)
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email
                ),
                trailingIcon = {
                    Image(

                        painter = painterResource(id = R.drawable.subtract),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .padding(end = 5.dp), alignment = Alignment.Center
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(255, 255, 255, 255),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp, top = 10.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            Text(
                text = "Password",
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 25.dp, top = 25.dp),
                style = TextStyle(
                    fontFamily = rubikRegular,
                    fontSize = 15.sp, color = Color(19, 73, 123)
                )
            )


            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = rubikRegular,
                    color = Color(0, 0, 0, 100)
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),
                trailingIcon = {
                    Image(

                        painter = painterResource(id = R.drawable.eye),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .padding(end = 5.dp), alignment = Alignment.Center
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(255, 255, 255, 255),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp, top = 10.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp)
                    ), visualTransformation = PasswordVisualTransformation()
            )

            TextButton(
                onClick = onClick,
                modifier = Modifier
                    .padding(top = 35.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
                    .background(
                        fontColor,
                        shape = RoundedCornerShape(10.dp)
                    )

            ) {
                Text(
                    text = "LOGIN", style = TextStyle(
                        color = Color.White, fontFamily = rubikMedium
                    )
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp, top = 35.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Forgot password?",
                    style = TextStyle(
                        color = Color.Black, fontFamily = rubikLight, fontSize = 14.sp
                    )
                )


                Text(
                    text = "create new account", style = TextStyle(
                        color = fontColor, fontFamily = rubikMedium
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(isEmail: Boolean) {


}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview() {
    LoginScreen(rememberNavController()){

    }
//    BottomNavigationScreen(navController)
    // BottomNavigationBar(navController)
}