package com.rexxy.aurawalls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rexxy.aurawalls.navigation.NavGraph
import com.rexxy.aurawalls.ui.theme.AuraWallsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AuraWallsTheme {
                NavGraph()
            }
        }
    }
}