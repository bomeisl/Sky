package com.example.sky.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

@Composable
fun SkyBottomNavBar() {
    BottomAppBar(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        BottomNavigation() {
            val selectedItem: Boolean by remember { mutableStateOf(false) }

            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "")},
                selected = false,
                onClick = { /*TODO*/ }
            )

            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "")},
                selected = false,
                onClick = { /*TODO*/ }
            )

            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "")},
                selected = false,
                onClick = { /*TODO*/ }
            )

        }
    }
}