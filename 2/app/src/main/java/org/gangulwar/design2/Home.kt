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
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .size(50.dp),
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = null,
                    alignment = CenterStart
                )
                Row(
                    Modifier
                        .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Image(
                        modifier = Modifier.size(
                            width = 11.dp,
                            height = 14.dp
                        ),
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
                        modifier = Modifier.size(
                            width = 12.dp,
                            height = 8.dp
                        ),
                        painter = painterResource(id = R.drawable.down_arrow),
                        contentDescription = null
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.notification_bell),
                    contentDescription = null,
                    Modifier
                        .padding(end = 25.dp)
                        .size(width = 20.dp, height = 25.dp)

                )

                Image(

                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = null,
                    Modifier.padding(end = 20.dp)
                        .size(23.dp)
                        ,
                    alignment = CenterEnd
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
                        R.drawable.home_1,
                        3
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
                        R.drawable.home_2,
                        4
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
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
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
            .size(360.dp)
            .padding(top = 30.dp)
//            .background(
//                shape = RoundedCornerShape(20.dp),
//                color = Color.White
//            )
        ,
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
//                .background(
//                    shape = RoundedCornerShape(20.dp),
//                    color = Color.White
//                ),
                .clip(shape = RoundedCornerShape(20.dp)),
            painter = painterResource(id = info.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                )
                .align(
                    Alignment.BottomCenter
                ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(
                        start = 20.dp,
                        end = 15.dp,
                        top = 5.dp,
                        bottom = 5.dp
                    )
            ) {

                Text(
                    modifier = Modifier.weight(1f),
                    text = info.name, style = TextStyle(
                        fontFamily = rubikRegular, fontSize = 20.sp,
                        color = colorResource(id = R.color.font_color)
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
//                        .wrapContentHeight(),
//                    verticalAlignment = Alignment.CenterVertically,
                    , horizontalArrangement = Arrangement.End
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically
//                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.profile_photo),
                            contentDescription = null
                        )

                        Text(
                            modifier = Modifier.padding(start = 10.dp)
//                            .fillMaxHeight()
//                            .align(alignment = Center)
                            ,
                            text = info.postedBy,
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = rubikLight,
                                color = colorResource(id = R.color.font_color)
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                    Text(
                        text = "$${info.price.toString()} usd", style = TextStyle(
                            fontFamily = rubikMedium,
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.font_color)
                        ),
                        textAlign = TextAlign.End
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val selStar = info.rating
                    repeat(selStar) {
                        Image(
                            modifier = Modifier.size(12.dp),
                            painter = painterResource(
                                id = R.drawable.sel_star
                            ), contentDescription = null
                        )
                    }

                    repeat(5 - selStar) {
                        Image(
                            modifier = Modifier.size(12.dp),
                            painter = painterResource(
                                id = R.drawable.del_star
                            ), contentDescription = null
                        )
                    }



                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .alpha(0.2f),
                        text = "${info.opinions} opinions", style = TextStyle(
                            fontFamily = rubikLight,
                            fontSize = 9.sp,
                            color = Color.Black,
                        )
                    )

                    val pairedValues = listOf(
                        Pair(painterResource(id = R.drawable.bed), info.bedroom),
                        Pair(painterResource(id = R.drawable.tub), info.bathroom),
                        Pair(painterResource(id = R.drawable.dine), info.kitchen)
                    )


                    Row(
                        Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {

                        pairedValues.forEach {

                            Image(
                                modifier = Modifier.padding(start = 10.dp, end = 3.dp),
                                painter = it.first,
                                contentDescription = null
                            )

                            Text(
                                text = it.second.toString(),
                                style = TextStyle(
                                    fontFamily = rubikRegular,
                                    fontSize = 12.sp,
                                    color = colorResource(
                                        id = R.color.light_font
                                    )
                                )
                            )
                        }
                        /*
                                                Image(
                                                    modifier=Modifier.padding(start = 10.dp, end = 3.dp),
                                                    painter = painterResource(id = R.drawable.tub),
                                                    contentDescription = null
                                                )

                                                Text(
                                                    text = info.bathroom.toString(),
                                                    style = TextStyle(
                                                        fontFamily = rubikRegular,
                                                        fontSize = 12.sp,
                                                        color = colorResource(
                                                            id = R.color.light_font
                                                        )
                                                    )
                                                )

                                                Image(
                                                    modifier=Modifier.padding(start = 10.dp, end = 3.dp),
                                                    painter = painterResource(id = R.drawable.dine),
                                                    contentDescription = null
                                                )

                                                Text(
                                                    text = info.kitchen.toString(),
                                                    style = TextStyle(
                                                        fontFamily = rubikRegular,
                                                        fontSize = 12.sp,
                                                        color = colorResource(
                                                            id = R.color.light_font
                                                        )
                                                    )
                                                )
                        */
                    }
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.heart_icon),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
//                .clip(CircleShape)
                .align(Alignment.TopEnd)
                .offset(x = (-35).dp, y = 200.dp)
                .background(Color.White, CircleShape)
                .shadow(1.dp, CircleShape)
                .padding(10.dp)
        )
        /*
//        Box(
//            modifier = Modifier
//                .size(50.dp)
//                .clip(CircleShape)
////                .align(Alignment.TopEnd)
////                .offset(x = 0.dp, y = 200.dp)
//                .background(Color.White, CircleShape)
//                .shadow(4.dp, CircleShape) // Add shadow to the background
//        ) {
//            Image(
//            painter = painterResource(id = R.drawable.heart_icon),
//            contentDescription = null,
//            modifier = Modifier
//                .size(50.dp)
////                .clip(CircleShape)
//                .align(Alignment.TopEnd)
//                .offset(x = 0.dp, y = 200.dp)
//                .background(Color.White, CircleShape)
//                .shadow(1.dp, CircleShape)
//                .padding(10.dp)
//        )
//        }
    }*/

        Card() {

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
    val image: Int,
    val rating: Int
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
    showSystemUi = true,
    name = "Home Preview"
)
@Composable
fun Preview1() {
    Home()
}
