import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.doganur.movieapp.navigation.Screen

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favourites,
        BottomNavItem.Basket
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route::class.java.canonicalName, //cur
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(
    val route: Screen,
    val title: String,
    val icon: ImageVector
) {
    data object Home : BottomNavItem(
        route = Screen.Home,
        title = "Ana Sayfa",
        icon = Icons.Default.Home
    )
    
    data object Favourites : BottomNavItem(
        route = Screen.Favourites,
        title = "Favoriler",
        icon = Icons.Default.Favorite
    )
    
    data object Basket : BottomNavItem(
        route = Screen.Basket,
        title = "Sepet",
        icon = Icons.Default.ShoppingCart
    )
} 