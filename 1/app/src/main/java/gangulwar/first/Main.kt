package gangulwar.first

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationScreen(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorites,
        BottomNavItem.Cart,
        BottomNavItem.Notification
    )

    var selected by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
//                modifier = Modifier.fillMaxWidth().height(117.dp)
//                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                backgroundColor = Color.White,
                modifier = Modifier.height(75.dp)
            ) {
                items.forEachIndexed { index, item ->
                    val isSelected = index == selected
                    BottomNavigationItem(
                        icon = {
                            val icon = if (isSelected) item.selectedIcon else item.icon
                            Image(
                                painter = painterResource(id = icon),
                                contentDescription = null, modifier = Modifier.size(25.dp)
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            selected = index
                            navController.navigate(item.route)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController as NavHostController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) {
                HomeScreen()
            }
            composable(BottomNavItem.Favorites.route) {
                FavoritesScreen()
            }
            composable(BottomNavItem.Cart.route) {
                CartScreen()
            }

            composable(BottomNavItem.Notification.route) {
                NotificationScreen()
            }
        }
    }
}

sealed class BottomNavItem(
    val route: String,
    val icon: Int,
    val selectedIcon: Int
) {
    object Home : BottomNavItem("home", R.drawable.home_des, R.drawable.home_selected)
    object Favorites : BottomNavItem("favorites", R.drawable.fav_deseleted, R.drawable.fav_seleted)
    object Cart : BottomNavItem("cart", R.drawable.cart_des, R.drawable.cart_sel)
    object Notification :
        BottomNavItem("notification", R.drawable.notification_desel, R.drawable.notification_sel)
}

@Composable
fun HomeScreen() {
    Home(name = "Aarsh")
}

@Composable
fun CartScreen() {
    TextView(name = "Cart Screen")
}

@Composable
fun FavoritesScreen() {
    TextView(name = "Favorites Screen")
}

@Composable
fun NotificationScreen() {
    TextView(name = "Notification Screen")
}

@Composable
fun TextView(name: String) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is $name", style =
            TextStyle(
                fontSize = 25.sp
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(name: String, modifier: Modifier = Modifier) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = R.drawable.home),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Location", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = soraSemiBold
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Bilzen, Tanjungbalai", style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontFamily = soraSemiBold
                                ,
                                textAlign = TextAlign.Center
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.down_arrow),
                            contentDescription = null,
                            Modifier
                                .size(25.dp)
                                .padding(start = 5.dp),
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(25.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user_image),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }


            }
            var text by remember { mutableStateOf("Search coffee") }
            TextField(
                value = text,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White, fontFamily = soraSemiBold
                ),
                onValueChange = {
                    text = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)

                    )
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(end = 5.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(color = 0xFF313131),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(15.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.main_promo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(500.dp, 150.dp)
            )


            CoffeeListRecycler(
                names = listOf(
                    "Cappuccino",
                    "Machiato",
                    "Latte",
                    "Americano",
                    "Espresso",
                    "Mocha",
                    "Affogato",
                    "Ristretto",
                    "Flat White"
                )
            )

            val coffee1 =
                CoffeeModal("Espresso", 4.5, "Milk", 2.99, R.drawable.cappucino_chocolate)
            val coffee2 =
                CoffeeModal("Cappuccino", 4.2, "Cream", 3.49, R.drawable.cappaucino_oat)
            val coffee3 = CoffeeModal("Latte", 4.0, "Honey", 4.25, R.drawable.coffee_3)
            val coffee4 = CoffeeModal("Mocha", 4.3, "Chocolate", 3.99, R.drawable.coffee_4)
            var modals = listOf<CoffeeModal>(coffee1, coffee2, coffee3, coffee4)
            CoffeeListing(modals)


        }

    }

}

@Composable
fun CoffeeListItem(
    name: String,
    isSelected: Boolean,
    onItemClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(
                if (isSelected) Color(198, 124, 78) else Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {
                onItemClicked()
            }
    ) {
        Text(
            text = name,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.padding(10.dp), fontFamily = soraSemiBold
        )
    }
}

@Composable
fun CoffeeListRecycler(names: List<String>) {
    var selectedCoffee by remember { mutableStateOf("Cappuccino") }

    LazyRow(modifier = Modifier.padding(top = 15.dp, start = 3.dp)) {
        items(names) { coffeeName ->
            CoffeeListItem(
                name = coffeeName,
                isSelected = coffeeName == selectedCoffee
            ) {
                selectedCoffee = coffeeName
            }
        }
    }
}

@Composable
fun CoffeeListing(
    modal: List<CoffeeModal>
) {
    Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
        Column(Modifier.weight(1f)) {
            ImageWithTextOverlay(modal = modal[0])
            ImageWithTextOverlay(modal = modal[3])
        }
        Column(Modifier.weight(1f)) {
            ImageWithTextOverlay(modal = modal[1])
            ImageWithTextOverlay(modal = modal[2])
        }
    }
}

@Composable
fun ImageWithTextOverlay(modal: CoffeeModal) {
    val name = modal.name
    val rating = modal.rating
    var withIngredient = modal.withIngredient
    var price = modal.price
    var image = modal.image

    Box(
        modifier = Modifier
            .padding(3.dp)
            .background(Color.White, shape = RoundedCornerShape(15.dp))
    ) {
        Column() {
            Box(
                modifier = Modifier
//                    .size(175.dp, 175.dp)
                    .padding(3.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(3.dp),
                    alignment = Alignment.Center
                )

                TextOverlay(rating)
            }
            Column(modifier = Modifier.padding(start = 25.dp, bottom = 15.dp)) {
                Text(
                    text = name,
                    color = Color(47, 45, 44),
                    fontFamily = soraSemiBold,
                    fontSize = 16.sp
                )

                Text(
                    text = "with $withIngredient",
                    color = Color(155, 155, 155),
                    fontFamily = soraRegular,
                    fontSize = 12.sp
                )

                Row(
                    modifier = Modifier
                        .padding(top = 10.dp, end = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$ $price",
                        color = Color(47, 75, 78),
                        fontFamily = soraSemiBold,
                        fontSize = 20.sp
                    )
                    Image(
                        modifier = Modifier.size(45.dp),
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = null,
                    )
                }
            }

        }
    }
}

@Composable
fun TextOverlay(text: Double) {
    Box(
        modifier = Modifier
            .padding(start = 3.dp, top = 3.dp)
            .background(
//                Color.White.copy(alpha = 0.1f),
                Color.Black.copy(alpha = 0.5f),
                shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            )
            .padding(8.dp)

    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                Modifier.size(10.dp)
            )
            Text(
                text = text.toString(),
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 3.dp),
                fontFamily = soraSemiBold
//                modifier = Modifier.align(Alignment.TopStart)
            )

        }

    }
}
