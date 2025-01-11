package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.doganur.movieapp.domain.model.SortType

@Composable
fun SortMenu(
    modifier: Modifier = Modifier,
    selectedSortType: SortType,
    onSortTypeSelect: (SortType) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Sort",
                tint = Color.Black
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            SortType.entries.forEach { sortType ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = when (sortType) {
                                SortType.NEWEST -> "En Yeni"
                                SortType.PRICE_ASC -> "Fiyat (Artan)"
                                SortType.PRICE_DESC -> "Fiyat (Azalan)"
                                SortType.NAME_ASC -> "İsim (A-Z)"
                                SortType.NAME_DESC -> "İsim (Z-A)"
                                SortType.RATE_ASC -> "Puan (Artan)"
                            },
                            color = if (sortType == selectedSortType) Color.Black else Color.Gray
                        )
                    },
                    onClick = {
                        onSortTypeSelect(sortType)
                        expanded = false
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomSheetExamplePreview() {
    SortMenu(
        selectedSortType = SortType.PRICE_ASC,
        onSortTypeSelect = { }
    )
}