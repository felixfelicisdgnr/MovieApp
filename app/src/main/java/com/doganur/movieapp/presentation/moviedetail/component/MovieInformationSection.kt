package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.doganur.movieapp.R
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle
import com.doganur.movieapp.presentation.theme.UrbanistMediumTextStyle
import com.doganur.movieapp.presentation.theme.UrbanistRegularTextStyle

@Composable
fun MovieInformationSection(
    name: String,
    image: String,
    description: String,
    category: String,
    rating: String,
    year: String,
    director: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(space = 15.dp),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(15.dp))
                    .size(
                        width = 150.dp,
                        height = 200.dp
                    ),
                model = image,
                contentDescription = stringResource(id = R.string.cont_desc_image_movie),
                contentScale = ContentScale.Crop
            )


            Text(
                text = name,
                style = UrbanistBoldTextStyle.copy(
                    fontSize = 24.sp,
                    color = BlackColor,
                    textAlign = TextAlign.Start
                )
            )
        }

        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.description),
                style = UrbanistMediumTextStyle.copy(
                    fontSize = 18.sp,
                    color = BlackColor,
                    textAlign = TextAlign.Start
                )
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = description,
                style = UrbanistRegularTextStyle.copy(
                    fontSize = 16.sp,
                    color = BlackColor,
                    textAlign = TextAlign.Start
                )
            )
        }

        MovieInformationChipsMenu(
            category = category,
            rating = rating,
            year = year,
            director = director
        )
    }
}

@Preview
@Composable
fun MovieInformationSectionPreview() {
    AppTheme {
        MovieInformationSection(
            name = "Movie Name",
            image = "https://image",
            description = "DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionvv",
            category = "Action",
            rating = "4.5",
            year = "2021",
            director = "Director Name"
        )
    }
}