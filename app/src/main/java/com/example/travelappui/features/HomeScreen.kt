package com.example.travelappui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.travelappui.model.HomeTripModel
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(navController: NavController) {

    LazyColumn(modifier = Modifier.fillMaxWidth()) {


        item {
            HomeHeader()
        }

        item {
            Text(
                text = "TRENDING TRIP IDEAS",
                color = Color.Black,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 16.dp,
                    bottom = 16.dp
                ),
            )
        }

        itemsIndexed(triplisting) { position, data ->
            HomeTripItem(
                homeTripModel = data,
                navController = navController)
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }

    }
}

@Composable
@Preview
fun HomeHeader() {
    val homeHeaderBg =
        "https://images.unsplash.com/photo-1622499490584-287480299d41?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
    Box {
        Image(
            painter = rememberCoilPainter(request = homeHeaderBg, fadeIn = true),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .alpha(0.2f)
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .statusBarsPadding()
                .padding(16.dp)
        ) {
            Text(
                text = "Good Morning",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 38.sp,
                letterSpacing = (-1).sp
            )
            Text(
                text = "What do you want to book today ?",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = ((-0.2).sp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {


                VerticalButton(vector = Icons.Filled.AirplanemodeActive, text = "Flights")
                VerticalButton(vector = Icons.Filled.DirectionsCar, text = "Cars")
                VerticalButton(vector = Icons.Filled.Business, text = "Hotel")
                VerticalButton(vector = Icons.Filled.LocalShipping, text = "Cruise")

            }


        }


    }
}

@Composable
fun VerticalButton(vector: ImageVector, text: String) {

    Button(


        colors = ButtonDefaults
            .buttonColors(backgroundColor = Color.White),
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                imageVector = vector, contentDescription = ""
            )

            Text(text = text)

            Spacer(modifier = Modifier.height(8.dp))

        }


    }

}

@Composable
fun HomeTripItem(homeTripModel: HomeTripModel,navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = homeTripModel.title,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            lineHeight = 24.sp
        )
        Spacer(modifier =Modifier.padding(8.dp))
        Image(
            painter = rememberCoilPainter(request = homeTripModel.image, fadeIn = true),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    navController.navigate("detail")
                }
                .height(200.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row() {

            Text(
                text = homeTripModel.dayPerson,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = Color(255, 215, 0),
                modifier = Modifier
                    .padding(4.dp)
                    .size(12.dp)
                    .align(CenterVertically)
            )

            Text(
                text = homeTripModel.rating.toString(),
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))


    }

}

var triplisting= listOf<HomeTripModel>(
    HomeTripModel(
        "https://images.unsplash.com/photo-1520277872024-58b40679ddb4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fGhvbGlkYXklMjB2aWV3fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2021",
        4.8f
    ),
    HomeTripModel(
        "https://images.unsplash.com/photo-1542213493895-edf5b94f5a96?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjd8fHN1bW1lcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
        "7 Days / 2 Person",
        "How to get around India on the cheap budget in 2021",
        5.9f
    ),
    HomeTripModel(
        "https://images.unsplash.com/photo-1561571994-3c61c554181a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDF8fHN1bW1lcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
        "7 Days / 2 Person",
        "Thailand Super Saver with only $1000 in 2021",
        4.8f
    ),
    HomeTripModel(
        "https://images.unsplash.com/photo-1533105079780-92b9be482077?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Njh8fHN1bW1lcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
        "7 Days / 2 Person",
        "How to get around India on the cheap budget in 2021",
        5.9f
    ),




)
