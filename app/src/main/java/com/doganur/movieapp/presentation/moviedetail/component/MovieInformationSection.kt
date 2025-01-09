package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.doganur.movieapp.R
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle
import com.doganur.movieapp.presentation.theme.UrbanistMediumTextStyle
import com.doganur.movieapp.presentation.theme.UrbanistRegularTextStyle

@Composable
fun MovieInformationSection(
    name: String,
    image: String,
    category: String,
    rating: String,
    year: String,
    director: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .size(
                        width = 150.dp,
                        height = 200.dp
                    )
                    .background(BlackColor),
                model = image,
                contentDescription = stringResource(id = R.string.cont_desc_image_movie),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(space = 4.dp)
            ) {
                Text(
                    text = name,
                    style = UrbanistBoldTextStyle.copy(
                        fontSize = 24.sp,
                        color = BlackColor,
                        textAlign = TextAlign.Start
                    )
                )

                Text(
                    text = stringResource(id = R.string.category) + category,
                    style = UrbanistRegularTextStyle.copy(
                        fontSize = 20.sp,
                        color = BlackColor,
                        textAlign = TextAlign.Start
                    )
                )

                Text(
                    text = stringResource(id = R.string.rating) + rating,
                    style = UrbanistRegularTextStyle.copy(
                        fontSize = 20.sp,
                        color = BlackColor,
                        textAlign = TextAlign.Start
                    )
                )

                Text(
                    text = stringResource(id = R.string.year) + year,
                    style = UrbanistRegularTextStyle.copy(
                        fontSize = 20.sp,
                        color = BlackColor,
                        textAlign = TextAlign.Start
                    )
                )

                Text(
                    text = stringResource(id = R.string.director) + director,
                    style = UrbanistRegularTextStyle.copy(
                        fontSize = 20.sp,
                        color = BlackColor,
                        textAlign = TextAlign.Start
                    )
                )

            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.description),
            style = UrbanistMediumTextStyle.copy(
                fontSize = 22.sp,
                color = BlackColor,
                textAlign = TextAlign.Start
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = description,
            style = UrbanistRegularTextStyle.copy(
                fontSize = 20.sp,
                color = BlackColor,
                textAlign = TextAlign.Start
            )
        )
    }
}

@Preview
@Composable
fun MovieInformationSectionPreview() {
    MovieInformationSection(
        name = "Movie Name",
        image = "https://image",
        category = "Action",
        rating = "8.5",
        year = "2021",
        director = "Director Name",
        description = "DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionvv"
    )
}