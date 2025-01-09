package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistRegularTextStyle

@Composable
fun SearchTextField(
    searchTextValue: String,
    onSearchValueChange: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
    ) {
        TextField(
            modifier = Modifier
                .padding(start = 8.dp)
                .fillMaxWidth()
                .clickable(onClick = {}),
            value = searchTextValue,
            onValueChange = { newValue ->
                onSearchValueChange(newValue)
            },
            placeholder = {
                Text(
                    text = "Search for a movie",
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
                disabledTextColor = Color.Black.copy(alpha = 0.5f),
                focusedPlaceholderColor = Color.Black,
                cursorColor = Color.Black.copy(alpha = 0.5f),
                disabledIndicatorColor = Color.Black.copy(alpha = 0.5f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.Transparent
            )
        )

        Icon(
            modifier = Modifier
                .size(24.dp),
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Icon",
            tint = Color(0xFFB4B4B6),
        )
    }
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    SearchTextField(
        searchTextValue = "",
        onSearchValueChange = {}
    )
}