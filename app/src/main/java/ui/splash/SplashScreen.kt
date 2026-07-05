package com.rexxy.aurawalls.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wallpaper
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rexxy.aurawalls.ui.theme.AuraWallsTheme

/**
 * The Splash Screen for AuraWalls.
 * Centered logo and app name with a timed transition to the main content.
 */
@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit,
    viewModel: SplashViewModel = viewModel()
) {
    val isFinished by viewModel.isFinished.collectAsState()

    // Trigger navigation callback when ViewModel signals completion
    LaunchedEffect(isFinished) {
        if (isFinished) {
            onSplashFinished()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // App Logo Placeholder
                Icon(
                    imageVector = Icons.Default.Wallpaper,
                    contentDescription = null,
                    modifier = Modifier.size(120.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(24.dp))

                // App Name
                Text(
                    text = "AuraWalls",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    AuraWallsTheme {
        SplashScreen(onSplashFinished = {})
    }
}