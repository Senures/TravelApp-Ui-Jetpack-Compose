package com.example.travelappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelappui.features.DetailScreen
import com.example.travelappui.features.HomeScreen
import com.example.travelappui.features.SplashScreen
import com.example.travelappui.ui.theme.TravelAppUiTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            TravelAppUiTheme {
               val navController= rememberNavController()
                //navcontrollerı tanımladık
                
                ProvideWindowInsets {


                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        NavHost(navController =navController,
                        startDestination = "splash"){
                            composable("splash"){
                               SplashScreen(navController)
                            }
                            composable("home"){
                                HomeScreen(navController)
                            }
                            composable("detail"){
                               DetailScreen(navController, )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TravelAppUiTheme {
        Greeting("Android")
    }
}