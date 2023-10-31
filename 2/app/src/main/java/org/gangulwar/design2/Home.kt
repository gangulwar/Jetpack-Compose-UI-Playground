package org.gangulwar.design2

import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
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

//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(
//                rememberScrollState()
//            )
//    ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
//                .verticalScroll(rememberScrollState())
        ) {
            //Column {
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
                modifier = Modifier.padding(25.dp)
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
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = null
                        )
                    }, trailingIcon = {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.filters),
                            contentDescription = null
                        )
                    }
                )
                MainCategory()
                val homes = listOf(
                    HomeInfo(
                        "Special House mix",
                        "Timmy bremer",
                        "Los angeles, CA",
                        1500,
                        20,
                        2,
                        1,
                        1,
                        R.drawable.home_1
                    ),
                    HomeInfo(
                        "Department Name",
                        "Timmy bremer",
                        "Los angeles, CA",
                        1500,
                        20,
                        2,
                        1,
                        1,
                        R.drawable.home_2
                    )

                )

                repeat(2) {
                    HomeInfoCard(info = homes[0])
                }
            }


        }

    }
}

@Composable
fun MainCategory() {

    var selectedCategory by remember {
        mutableStateOf("Home")
    }

    val items = listOf(
        Category("Home", R.drawable.home_sel, R.drawable.home_desel, isSelected = true),
        Category("Flat", R.drawable.flat_sel, R.drawable.flat_desel, isSelected = false),
        Category("Keys", R.drawable.key_sel, R.drawable.key_desel, isSelected = false),
        Category("Promo", R.drawable.promo_sel, R.drawable.promo_desel, isSelected = false)
    )
    // val scrollState = rememberScrollState()

//    LazyColumn(modifier = Modifier.fillMaxSize()) {
//        item {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(items) { item ->
            if (item.categoryName == selectedCategory) {
                SelectedCard(category = item)
            } else {
                DeselectedCard(category = item) {
                    selectedCategory = item.categoryName
                }
            }
        }
    }
    // HomeInfoCard(homes[0], 2)

//        items(homes) { home ->
//            HomeInfoCard(info = home)
//        }
//    }


}

@Composable
fun HomeInfoCard(info: HomeInfo) {

    Box(
        modifier = Modifier
            .size(350.dp)
            .padding(top = 30.dp)
            .background(shape = RoundedCornerShape(20.dp), color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = info.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Image(
            painter = painterResource(id = R.drawable.heart_icon),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
//                .clip(CircleShape)
                .align(Alignment.TopEnd)
                .offset(x = 0.dp, y = 200.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(shape = RoundedCornerShape(20.dp), color = Color.White)
                .align(
                    Alignment.BottomCenter
                )
        ) {



            Column() {
                Text(text = "Hello World")
            }
        }
    }
}

data class Category(
    val categoryName: String,
    val selDrawableID: Int,
    val deselDrawableID: Int,
    val isSelected: Boolean
)

data class HomeInfo(
    val name: String,
    val postedBy: String,
    val location: String,
    val price: Int,
    val opinions: Int,
    val bedroom: Int,
    val bathroom: Int,
    val kitchen: Int,
    val image: Int
)

@Composable
fun SelectedCard(category: Category) {

    Card(
        modifier = Modifier
            //.padding(top = 15.dp, end = 3.dp)
            .size(80.dp, 100.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(70, 208, 217)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = category.selDrawableID
                ),
                contentDescription = null,
                Modifier.size(50.dp)
            )
            Text(
                text = category.categoryName,
//                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = rubikMedium,
                    color = Color.White
                )
            )
        }
    }
}


@Composable
fun DeselectedCard(category: Category, onCardClick: () -> Unit) {

    Card(
        modifier = Modifier
            // .padding(top = 15.dp, end = 10.dp)
            .size(75.dp, 75.dp)
            .clickable { onCardClick() }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = category.deselDrawableID
                ),
                contentDescription = null,
                Modifier.size(50.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview1() {
    Home()
}
