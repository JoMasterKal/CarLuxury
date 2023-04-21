package com.example.carluxury.ui.screens.carDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.carluxury.R
import com.example.carluxury.ui.screens.home.Car
import com.example.carluxury.ui.theme.Shapes
import com.example.carluxury.ui.theme.grey2
import com.example.carluxury.ui.theme.mallow1
import com.example.carluxury.ui.theme.orange2
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle


@Composable
fun DetailScreen(car: Car, modifier: Modifier = Modifier) {

    Scaffold(topBar = { TopBarDetail() }) { padding ->
        Column(modifier = modifier.padding(padding)) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(car.image)
                    .crossfade(true)
                    .build(),
                loading = {
                    CircularProgressIndicator()
                },
                //error = painterResource(R.drawable.ic_broken_image),
                //placeholder = painterResource(R.drawable.loading_img),
                contentDescription = "Amphibian Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(250.dp)
                    .padding(start = 16.dp, top = 64.dp, end = 16.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 64.dp, start = 32.dp)
            ) {
                ProductInfo(car = car, modifier = Modifier)
                Spacer(modifier = Modifier.weight(1f))
                ProductPrice(price = car.price, modifier = Modifier)

            }
            BottomButtonBar()

            Button(
                onClick = { },
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = mallow1,
                    contentColor = MaterialTheme.colors.background,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "buy now",
                    style = MaterialTheme.typography.h6,
                )
            }

        }
    }

}

@Composable
fun ProductInfo(car: Car, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = car.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = car.description,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify,
            color = grey2,
            modifier = Modifier.padding(4.dp)
        )

        Row(modifier = Modifier.padding(top = 16.dp)) {
            RatingBar(
                value = 4.0F,
                config = RatingBarConfig()
                    .style(RatingBarStyle.HighLighted),
                onValueChange = {

                },
                onRatingChanged = {
                }
            )

            Text(
                text = "2.2k",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 8.dp, top = 7.dp)
            )

        }



        Text(
            text = stringResource(R.string.about_this_product),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = car.about,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify,
            color = grey2,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun ProductPrice(price: Double, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(
            topEnd = 0.dp,
            topStart = 50.dp,
            bottomEnd = 0.dp,
            bottomStart = 50.dp
        ),
        backgroundColor = orange2,
        modifier = modifier.height(43.dp)

    ) {
        Row(
            Modifier
                .defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = ButtonDefaults.MinHeight
                )
                .padding(ButtonDefaults.ContentPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "$$price",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Composable
fun TopBarDetail() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(color = MaterialTheme.colors.background)
    ) {
        IconButton(onClick = { }) {
//            Icon(
//                painter = painterResource(id = R.drawable.arrow_back_ios),
//                tint = orange1,
//                contentDescription = ""
//            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_back_ios),
                tint = MaterialTheme.colors.primary,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                tint = MaterialTheme.colors.primary,
                contentDescription = ""
            )

        }
    }
}

@Composable
fun BottomButtonBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {

        IconButton(
            onClick = { }, modifier = Modifier
                .size(45.dp)
                .padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                tint = MaterialTheme.colors.primary.copy(alpha = 0.6f),
                contentDescription = "",
                modifier = Modifier
                    .weight(0.5f)
                    .size(45.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { },

            elevation = ButtonDefaults.elevation(
                defaultElevation = 4.dp
            ),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.background,
            ),
            modifier = Modifier
                .alpha(0.6f)
                .size(45.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.remove),
                tint = MaterialTheme.colors.background,
                contentDescription = "",
            )
        }

        Spacer(modifier = Modifier.width(32.dp))

        Button(
            onClick = { },
            elevation = ButtonDefaults.elevation(
                defaultElevation = 4.dp
            ),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary.copy(),
                contentColor = MaterialTheme.colors.background,
            ),
            modifier = Modifier
                .size(45.dp)
                .alpha(0.6f)

        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                tint = MaterialTheme.colors.background,
                contentDescription = "",
            )
        }
    }
}

@Composable
@Preview()
fun DetailPreview() {
    DetailScreen(
        car = Car(
            image = "https://images.pexels.com/photos/3802510/pexels-photo-3802510.jpeg?auto=compress&cs=tinysrgb&w=800",
            name = "lamborghini",
            description = "this is a car for your life",
            price = 600000.0,
            about = ""
        )
    )
}

