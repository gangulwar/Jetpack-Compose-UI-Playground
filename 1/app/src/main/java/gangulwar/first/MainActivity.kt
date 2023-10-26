package gangulwar.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import gangulwar.first.ui.theme.FirstTheme

val soraRegular = FontFamily(
    Font(R.font.sora_regular)
)

val soraSemiBold = FontFamily(
    Font(R.font.sora_semi_bold)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main(){
    val navController = rememberNavController()
    BottomNavigationScreen(navController)
}

@Preview(
    showBackground = true, showSystemUi = true, name = "Home Screen"
)
@Composable
fun GreetingPreview() {
    FirstTheme {
        Main()
    }
}