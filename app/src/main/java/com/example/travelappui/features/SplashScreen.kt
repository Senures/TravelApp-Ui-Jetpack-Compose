package com.example.travelappui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun SplashScreen (navController: NavController){
    var splashUrl="https://images.unsplash.com/photo-1516483638261-f4dbaf036963?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=386&q=80"
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Red)) {
        Image(painter = rememberCoilPainter(request = splashUrl),
            contentDescription ="",
            contentScale=ContentScale.Crop,
            modifier =Modifier.fillMaxSize()
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(16.dp)
            .navigationBarsPadding()
            .background(
                color = Color.White.copy(alpha = 0.6f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp)
        ) {
            Text(
                text = "Explore\nNew Places",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                letterSpacing = (-1).sp
            )

            Text(
                text = "Exploria will help you to find new hotels, book cheap flights and lot more.",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = (-0.1).sp
            )
            Button(
                onClick = {
                          navController.navigate("home")
                },
            modifier= Modifier
                .padding(8.dp)
                .fillMaxWidth(),
                colors = ButtonDefaults
                    .buttonColors(backgroundColor = Color.Transparent)) {
                Text(text = "Get Started",
                fontSize =18.sp)
                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = ""
                )

            }
        }
        
    }
}

