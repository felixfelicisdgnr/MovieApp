package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.doganur.movieapp.domain.model.SortType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortMenu(
    selectedSortType: SortType,
    onSortTypeSelect: (SortType) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Sort"
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            SortType.values().forEach { sortType ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = when (sortType) {
                                SortType.PRICE_ASC -> "Fiyat (Artan)"
                                SortType.PRICE_DESC -> "Fiyat (Azalan)"
                                SortType.NEWEST -> "En Yeni"
                                SortType.NAME_ASC -> "İsim (A-Z)"
                                SortType.NAME_DESC -> "İsim (Z-A)"
                                SortType.RATE_ASC -> "Puan (Artan)"
                            }
                        )
                    },
                    onClick = {
                        onSortTypeSelect(sortType)
                        expanded = false
                    }
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