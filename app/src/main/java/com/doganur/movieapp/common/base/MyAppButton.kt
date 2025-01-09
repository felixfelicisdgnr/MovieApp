package com.doganur.movieapp.common.base

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.PrimaryColor
import com.doganur.movieapp.presentation.theme.UrbanistSemiBoldTextStyle

@Composable
fun MyAppButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = UrbanistSemiBoldTextStyle.copy(
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    ),
    enabled: Boolean = true,
    shape: CornerBasedShape = RoundedCornerShape(10.dp),
    containerColor: Color = PrimaryColor,
    disabledContainerColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
    disabledContentColor: Color = PrimaryColor.copy(alpha = 0.4f),
    contentColor: Color = Color.White,
    iconModifier: Modifier = Modifier,
    icon: Int? = null,
    iconTint: Color = Color.Black,
    iconContentDescription: String? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContentColor = disabledContentColor,
            disabledContainerColor = disabledContainerColor
        ),
        shape = shape,
        onClick = onClick
    ) {
        icon?.let {
            Icon(
                modifier = iconModifier,
                painter = painterResource(icon),
                contentDescription = iconContentDescription,
                tint = iconTint
            )

            Spacer(modifier = Modifier.width(7.dp))
        }

        Text(
            text = text.uppercase(),
            style = textStyle
        )
    }
}

@Preview
@Composable
fun MyAppButtonPreview() {
    AppTheme {
        MyAppButton(
            text = stringResource(id = R.string.add_basket),
            onClick = {}
        )
    }
}