package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.domain.model.SortType
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistRegularTextStyle

@Composable
fun SearchTextField(
    searchTextValue: String,
    onSearchValueChange: (String) -> Unit,
    selectedSortType: SortType,
    onSortTypeSelect: (SortType) -> Unit,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(6f)
                .border(1.dp, Color.Gray, RoundedCornerShape(10.dp)),
            value = searchTextValue,
            onValueChange = { newValue ->
                onSearchValueChange(newValue)
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint),
                    style = UrbanistRegularTextStyle.copy(
                        fontSize = 16.sp,
                        color = BlackColor
                    )
                )
            },
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            colors = TextFieldDefaults.colors(
                disabledTextColor = Color.Black,
                cursorColor = Color.Black,
                focusedTextColor = Color.Black,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                unfocusedPlaceholderColor = Color.White,
                focusedPlaceholderColor = Color.White,
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.cont_desc_icon_search),
                    tint = Color.Black
                )
            }
        )

        SortMenu(
            modifier = Modifier
                .weight(1f),
            selectedSortType = selectedSortType,
            onSortTypeSelect = onSortTypeSelect
        )
    }
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    SearchTextField(
        searchTextValue = stringResource(id = R.string.search_hint),
        onSearchValueChange = {},
        selectedSortType = SortType.PRICE_ASC,
        onSortTypeSelect = {}
    )
}