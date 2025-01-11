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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.domain.model.SortType
import com.doganur.movieapp.presentation.theme.UrbanistRegularTextStyle

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
            onDismissRequest = { expanded = false },
            containerColor = Color.White,
        ) {
            SortType.entries.forEach { sortType ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = when (sortType) {
                                SortType.NEWEST -> stringResource(id = R.string.sort_newest)
                                SortType.PRICE_ASC -> stringResource(id = R.string.sort_price_asc)
                                SortType.PRICE_DESC -> stringResource(id = R.string.sort_price_desc)
                                SortType.NAME_ASC -> stringResource(id = R.string.sort_name_asc)
                                SortType.NAME_DESC -> stringResource(id = R.string.sort_name_desc)
                                SortType.RATE_ASC -> stringResource(id = R.string.sort_rate_asc)
                            },
                            color = if (sortType == selectedSortType) Color.Black else Color.Gray,
                            style = UrbanistRegularTextStyle.copy(
                                fontSize = 16.sp
                            )
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