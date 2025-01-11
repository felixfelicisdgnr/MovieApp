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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.doganur.movieapp.R
import com.doganur.movieapp.navigation.Screen

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorite,
        BottomNavItem.Basket
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = stringResource( item.title)) },
                label = { Text(text = stringResource(item.title) ) },
                selected = currentRoute == item.route::class.java.canonicalName,
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
    val title: Int,
    val icon: ImageVector
) {
    data object Home : BottomNavItem(
        route = Screen.Home,
        title =  R.string.home_page,
        icon = Icons.Default.Home
    )

    data object Favorite : BottomNavItem(
        route = Screen.Favorite,
        title = R.string.favorite_page,
        icon = Icons.Default.Favorite
    )

    data object Basket : BottomNavItem(
        route = Screen.Basket,
        title = R.string.basket_page,
        icon = Icons.Default.ShoppingCart
    )
} 